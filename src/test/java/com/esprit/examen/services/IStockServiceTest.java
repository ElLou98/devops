package com.esprit.examen.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.esprit.examen.entities.Stock;
import com.esprit.examen.repositories.StockRepository;

public class IStockServiceTest extends Tests {
   
	@Autowired
    StockServiceImpl ss  = new StockServiceImpl();
    

   
	
	@Test
	@Order(1)

	public void testretrieveAllStocks()
	{
		List<Stock> allStocks = ss.retrieveAllStocks();
		assertEquals(3,allStocks.size());
	}
	
	@Test
	@Order(2)
	public void testaddStock()
	{
		Stock s = new Stock("testtest",10,100);
		Stock saveds = ss.addStock(s);
		assertEquals(s.getLibelleStock(),saveds.getLibelleStock());
	}
	
	@Test
	@Order(3)
	public void testretrieveStock()
	{
		Stock saveds = ss.retrieveStock(1L);
		assertEquals(1L,saveds.getIdStock().longValue());
		
	}
	
	
	/*@Test
	@Order(4)
	public void testdeleteStock()
	{
		ss.deleteStock(15L);  
		assertNull(ss.retrieveStock(15L));
	
	}*/
	
	
	
}
