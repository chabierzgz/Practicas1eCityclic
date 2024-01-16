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
	
	@SuppressWarnings("deprecation")
	@Test
	public void testPotencias() {
		
		int resultadoPrueba = 64;
		
		int resultadoMetodo = (int) operacion.potenciaExponente(4, 3);
		
		assertEquals(resultadoPrueba, resultadoMetodo );
		
	}
}
