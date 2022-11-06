package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.springframework.beans.factory.annotation.Autowired;

import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.entities.Stock;

public class ISecteurActiviteServiceTest extends Tests {
	
	@Autowired
	ISecteurActiviteService ss;
	
	@Test
	public void testaddSecteurActivite()
	{
		SecteurActivite sa = new SecteurActivite("10","tunis");
		SecteurActivite sadb = ss.addSecteurActivite(sa);
		assertNotNull(sadb.getidSecteurActivite());
		assertNotNull(sadb.getlibelleSecteurActivite());
		ss.deleteSecteurActivite(sadb.getidSecteurActivite());
	}
	
	@Test
	public void testretrieveAllSecteurActivite()
	{
		List<SecteurActivite> allStocks = ss.retrieveAllSecteurActivite();
		int expected = allStocks.size();
		SecteurActivite sa = new SecteurActivite("10","tunis");
		SecteurActivite sadb = ss.addSecteurActivite(sa);
		assertEquals(expected,allStocks.size());
		ss.deleteSecteurActivite(sadb.getidSecteurActivite());
	}
	
	@Test
	public void testretrieveSecteurActivite()
	{   SecteurActivite sa = new SecteurActivite("10","tunis");
	    SecteurActivite sadb = ss.addSecteurActivite(sa);
		SecteurActivite sadb1 = ss.retrieveSecteurActivite(sadb.getidSecteurActivite());
		assertNotNull(sadb1);
		ss.deleteSecteurActivite(sadb.getidSecteurActivite());
	}
	
	@Test
	public void testUpdateCategorieProduit() throws ParseException
	{
		SecteurActivite sa = new SecteurActivite("10","tunis");
		SecteurActivite sadb = ss.addSecteurActivite(sa);
		SecteurActivite sa1 = new SecteurActivite(sadb.getidSecteurActivite(),"20", "gabes");
		SecteurActivite sadb1 = ss.updateSecteurActivite(sa1);
		assertEquals(sa.getidSecteurActivite(),sa1.getidSecteurActivite());
		assertNotEquals(sadb.getlibelleSecteurActivite(), sadb1.getlibelleSecteurActivite());
		ss.deleteSecteurActivite(sadb.getidSecteurActivite());
	}
	
	@Test
	public void testdeleteSecteurActivite()
	{   SecteurActivite sa = new SecteurActivite("10","tunis");
	    SecteurActivite sadb = ss.addSecteurActivite(sa);
		ss.deleteSecteurActivite(sadb.getidSecteurActivite());
		assertNull(ss.retrieveSecteurActivite(sadb.getidSecteurActivite()));
	}
	
	

}
