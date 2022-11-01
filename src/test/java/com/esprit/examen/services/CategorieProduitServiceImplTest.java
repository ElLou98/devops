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

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class CategorieProduitServiceImplTest {
	@Autowired
	ICategorieProduitService categorieProduitService;

	
	@Test
	public void testAddCategorie() throws ParseException {
		CategorieProduit c = new CategorieProduit("C001", "Alimentaire");
		CategorieProduit categorie = categorieProduitService.addCategorieProduit(c);
		System.out.print("Categorie "+categorie);
		assertNotNull(categorie.getIdCategorieProduit());
		assertNotNull(categorie.getCodeCategorie());
		assertTrue(categorie.getLibelleCategorie().length() > 0);
		categorieProduitService.deleteCategorieProduit(categorie.getIdCategorieProduit());
	}
	
	@Test
	public void testDeleteCategorie() throws ParseException {
		CategorieProduit c = new CategorieProduit("C001", "Alimentaire");
		CategorieProduit categorie = categorieProduitService.addCategorieProduit(c);
		categorieProduitService.deleteCategorieProduit(categorie.getIdCategorieProduit());
		assertNull(categorieProduitService.retrieveCategorieProduit(categorie.getIdCategorieProduit()));
	}

	@Test
	public void testRetrieveAllCategorie() throws ParseException {

		List<CategorieProduit> categories = categorieProduitService.retrieveAllCategorieProduits();
		int expected = categories.size();
		CategorieProduit c = new CategorieProduit("C001", "Alimentaire");
		CategorieProduit categorie = categorieProduitService.addCategorieProduit(c);
		assertEquals(expected + 1, categorieProduitService.retrieveAllCategorieProduits().size());
		categorieProduitService.deleteCategorieProduit(categorie.getIdCategorieProduit());

	}
	
	@Test
	public void testUpdateCategorieProduit() throws ParseException
	{
		CategorieProduit c = new CategorieProduit("C001", "Alimentaire");
		CategorieProduit categorie = categorieProduitService.addCategorieProduit(c);
		CategorieProduit c1 = new CategorieProduit(categorie.getIdCategorieProduit(),"C002", "Alimentaire");
		CategorieProduit categorie1 = categorieProduitService.updateCategorieProduit(c1);
		assertEquals(categorie.getIdCategorieProduit(),categorie1.getIdCategorieProduit());
		assertNotEquals(categorie1.getCodeCategorie(), categorie.getCodeCategorie());
		categorieProduitService.deleteCategorieProduit(categorie.getIdCategorieProduit());
	}
	
	@Test
	public void testRetrieveCategorieProduit() throws ParseException
	{
		CategorieProduit c = new CategorieProduit("C001", "Alimentaire");
		CategorieProduit categorie = categorieProduitService.addCategorieProduit(c);
		CategorieProduit categorie1 = categorieProduitService.retrieveCategorieProduit(categorie.getIdCategorieProduit());
		assertNotNull(categorie1);
		categorieProduitService.deleteCategorieProduit(categorie.getIdCategorieProduit());
	}

}
