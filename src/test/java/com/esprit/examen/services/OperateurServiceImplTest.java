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
import com.esprit.examen.entities.Operateur;
import com.esprit.examen.repositories.DetailFournisseurRepository;
import com.esprit.examen.repositories.FournisseurRepository;
import com.esprit.examen.repositories.OperateurRepository;
import com.esprit.examen.repositories.ProduitRepository;
import com.esprit.examen.repositories.SecteurActiviteRepository;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
@ExtendWith(MockitoExtension.class)
public class OperateurServiceImplTest {
	
	@Mock
	OperateurRepository operateurRepository;
	
	@InjectMocks
	OperateurServiceImpl operateurService;

	Operateur o = Operateur.builder().nom("bellili").prenom("bilel").password("123456").build();
	
	List<Operateur> list = new ArrayList<Operateur>(){
		{
			add(Operateur.builder().nom("bellili").prenom("bilel").password("123456").build());
			add(Operateur.builder().nom("hrizi").prenom("ilyess").password("azerty").build());
		}
		
	};
	
	
	@Test
	public void testRetrieveOperateur() throws ParseException
	{
		Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(o));
		Operateur operateur = operateurService.retrieveOperateur((long)2);
		assertNotNull(operateur);
		log.info("get ==>",operateur.toString());
	}
	
	
	@Test
	public void testAddOperateur() throws ParseException 
	{
		Operateur tempO = new Operateur("bellili","bilel", "123456");
		operateurService.addOperateur(tempO);
		verify(operateurRepository, times(1)).save(tempO);
	}
	
	@Test
	public void testRetrieveAllOperateurs() throws ParseException 
	{
		Mockito.when(operateurRepository.findAll()).thenReturn(list);
		List<Operateur> fourList = operateurService.retrieveAllOperateurs();
		assertEquals(2, fourList.size());
		verify(operateurRepository, times(1)).findAll();

	}

}