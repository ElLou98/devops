package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;

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
	@Order(1)
	public void testaddSecteurActivite()
	{
		SecteurActivite s = new SecteurActivite("10","tunis");
		SecteurActivite saveds = ss.addSecteurActivite(s);
		assertEquals(s.getlibelleSecteurActivite(),saveds.getlibelleSecteurActivite());
	}
	
	@Test
	@Order(2)
	public void testretrieveAllSecteurActivite()
	{
		List<SecteurActivite> allStocks = ss.retrieveAllSecteurActivite();
		assertEquals(4,allStocks.size());
	}
	
	@Test
	@Order(3)
	public void testretrieveSecteurActivite()
	{
		SecteurActivite saveds = ss.retrieveSecteurActivite(1L);
		assertEquals(1L,saveds.getidSecteurActivite().longValue());
	}

}
