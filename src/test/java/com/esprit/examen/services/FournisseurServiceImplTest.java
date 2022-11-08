package com.esprit.examen.services;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.esprit.examen.entities.CategorieFournisseur;
import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.entities.Fournisseur;
import com.esprit.examen.repositories.DetailFournisseurRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.SecteurActiviteRepository;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ExtendWith(MockitoExtension.class)
public class FournisseurServiceImplTest {
	
	@Mock
	FournisseurRepository fournisseurRepository;
	@Mock
	DetailFournisseurRepository detailFournisseurRepository;
	@Mock
	ProduitRepository produitRepository;
	@Mock
	SecteurActiviteRepository secteurActiviteRepository;
	
	@InjectMocks
	FournisseurServiceImpl fournisseurService;

	Fournisseur f = Fournisseur.builder().code("F001").libelle("Ups").categorieFournisseur(CategorieFournisseur.CONVENTIONNE).build();
	
	List<Fournisseur> list = new ArrayList<Fournisseur>(){
		{
			add(Fournisseur.builder().code("F002").libelle("FedEx").categorieFournisseur(CategorieFournisseur.CONVENTIONNE).build());
			add(Fournisseur.builder().code("F003").libelle("Autres").categorieFournisseur(CategorieFournisseur.ORDINAIRE).build());
		}
		
	};
	
	
	@Test
	public void testRetrieveFournisseur() throws ParseException
	{
		Mockito.when(fournisseurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(f));
		Fournisseur fournisseur = fournisseurService.retrieveFournisseur((long)2);
		assertNotNull(fournisseur);
		log.info("get ==>",fournisseur.toString());
	}
	
	
	@Test
	public void testAddFournisseur() throws ParseException 
	{
		Fournisseur tempF = new Fournisseur("F003","Autres");
		fournisseurService.addFournisseur(tempF);
		verify(fournisseurRepository, times(1)).save(tempF);
	}
	
	@Test
	public void testRetrieveAllFournisseur() throws ParseException 
	{
		Mockito.when(fournisseurRepository.findAll()).thenReturn(list);
		List<Fournisseur> fourList = fournisseurService.retrieveAllFournisseurs();
		assertEquals(2, fourList.size());
		verify(fournisseurRepository, times(1)).findAll();

	}
}
