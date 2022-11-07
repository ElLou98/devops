package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.verify;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.esprit.examen.entities.Facture;

import com.esprit.examen.repositories.FactureRepository;

public class IFactureServiceTest extends Tests {
   
	@Autowired
    FactureServiceImpl fs  = new FactureServiceImpl();
    

   
	
	@Test
	public void testretrieveAllFactures() throws ParseException
	{
		List<Facture> allFactures = fs.retrieveAllFactures();
		int expected = allFactures.size();
		assertEquals(expected, allFactures.size());
		
	}
	
	@Test
	public void testaddFacture() throws ParseException
	{
		Facture ft = new Facture(10, 2000);
		Facture ftdb = fs.addFacture(ft);
		assertEquals(ft.getIdFacture(),ftdb.getIdFacture());
		
	}
	

	
	
	
	
	
}