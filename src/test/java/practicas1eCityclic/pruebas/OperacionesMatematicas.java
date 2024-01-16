package practicas1eCityclic.pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ecityclic.practicas1eCityclic.helper.Operaciones;

public class OperacionesMatematicas {

	
	Operaciones operacion = new Operaciones();
	
	@Test
	public void testSuma() {
		
		assertEquals(8, operacion.suma(3, 5));
		
	}
	
	@Test
	public void testResta() {
		
		assertEquals(5, operacion.resta(10, 5));
		
	}

	@Test
	public void testMultiplica() {
		
		assertEquals(50, operacion.multiplica(10, 5));
		
	}
	
	@Test
	public void testPotencias() {
		
//		assertEquals(64, operacion.potenciaExponente(4, 3));
		
	}
}
