package testing;

import RSI.cursos.model.Cuenta;
import RSI.cursos.repository.CuentasRepository;
import RSI.cursos.service.CuentasService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:./WebContent/WEB-INF/springConfig.xml"})
public class AppTest {
	@Autowired
	CuentasService service;
	@Autowired
	CuentasRepository repository;
	
	@Before
	public void preTest() {
		service.newCuenta(new Cuenta(1, 100,  "Ahorro"));
	}
	
	@After
	public void postTest() {
		repository.findAll().clear();
	}
	
	@Test
	public void testUno() {
		assertFalse(service.newCuenta(new Cuenta(1 , 123, "Ahorro 2")));
		assertEquals(service.allCuentas().size(), 1);
	}
	
	@Test
	public void testDos() {
		assertTrue(service.newCuenta(new Cuenta(2 , 323, "Ahorro 3")));
		assertEquals(service.allCuentas().size(), 2);
	}
	
	@Test
	public void testTres() {
		assertTrue(service.newCuenta(new Cuenta(2 , 323, "Ahorro 3")));
		System.out.println("Saldo: "+service.allCuentas().get(0).getSaldo());
		assertEquals(100, service.allCuentas().get(0).getSaldo(), 0);
		assertEquals(323, service.allCuentas().get(1).getSaldo(), 0);
	}

}
