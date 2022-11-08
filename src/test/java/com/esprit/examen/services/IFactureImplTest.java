package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Facture;
import com.esprit.examen.repositories.FactureRepository;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class IFactureImplTest {
	@Autowired
	IFactureService FactureService;

	
	@Test
	public void testAddCategorie() throws ParseException {
		Facture f = new Facture(10, 10000);
		Facture fac = FactureService.addFacture(f) ;
		System.out.print("Facture "+fac);
		assertNotNull(fac.getIdFacture());
		assertNotNull(fac.getMontantFacture());
		assertTrue(fac.getMontantRemise() < fac.getMontantFacture());
		
	}
	


	@Test
	public void testRetrieveAllCategorie() throws ParseException {

		List<Facture> facs = FactureService.retrieveAllFactures();
		int expected = facs.size();
		Facture f = new Facture(10, 10000);
		Facture fac = FactureService.addFacture(f);
		assertEquals(expected + 1, FactureService.retrieveAllFactures().size());
	
	}
	


}