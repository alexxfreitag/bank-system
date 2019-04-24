package negocio;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.hamcrest.CoreMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class OrdemEventosTestes {

	@Before
	public void before() {
		System.out.println("@Before");
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("@BeforeClass");
	}
	
	@After
	public void after() {
		System.out.println("@After");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("@AfterClass");
	}
	
	@Test
	public void testeUm() {
			
		System.out.println("testeUm");
		
	}
	
	@Test
	public void testeDois()  {

		System.out.println("testeDois");
	}
}
