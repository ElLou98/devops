package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.esprit.examen.entities.Produit;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ProduitServiceImplTest {
	@Autowired
	IProduitService produitService;


	@Test
	public void testAddProduit() throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreation = dateFormat.parse("01/09/2020");
		Date datemodification = dateFormat.parse("30/09/2020");

		Produit c = new Produit("x4785", "AirForce one", 280,dateCreation ,datemodification);
		Produit produit = produitService.addProduit(c);
		System.out.print("Produit "+produit);
		assertNotNull(produit.getIdProduit());
		assertTrue(produit.getLibelleProduit().length() > 0);
		produitService.deleteProduit(produit.getIdProduit());

	}
	@Test
	public void testDeleteProduit() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreation = dateFormat.parse("01/09/2020");
		Date dateModification = dateFormat.parse("30/09/2020");
		Produit c = new Produit("x4785", "AirForce one", 280,dateCreation ,dateModification);
		Produit Produit = produitService.addProduit(c);
		produitService.deleteProduit(Produit.getIdProduit());
		assertNull(produitService.retrieveProduit(Produit.getIdProduit()));
	}

	@Test
	public void testRetrieveAllProduits() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date dateCreation = dateFormat.parse("30/09/2000");
		Date dateModification = dateFormat.parse("30/09/2020");
		List<Produit> Produits = produitService.retrieveAllProduits();
		int expected = Produits.size();
		Produit c = new Produit("x4785", "AirForce one", 280,dateCreation ,dateModification);
		Produit Produit = produitService.addProduit(c);
		assertEquals(expected + 1, produitService.retrieveAllProduits().size());
		produitService.deleteProduit(Produit.getIdProduit());
	}


}