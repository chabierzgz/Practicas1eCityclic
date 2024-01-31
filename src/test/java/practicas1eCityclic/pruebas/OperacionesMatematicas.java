package practicas1eCityclic.pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ecityclic.practicas1eCityclic.helper.OperacionesHelper;

public class OperacionesMatematicas {

	OperacionesHelper operacion = new OperacionesHelper();

	int num1 = (int) (Math.random() * 10);
	int num2 = (int) (Math.random() * 10);

	@Test
	public void testSuma() {

		int resultado = num1 - num2;

		assertEquals(resultado, operacion.resta(num1, num2));

	}

	@Test
	public void testResta() {

		int resultado = num1 - num2;

		assertEquals(resultado, operacion.resta(num1, num2));

	}

	@Test
	public void testMultiplica() {

		int resultado = num1 * num2;

		assertEquals(resultado, operacion.multiplica(num1, num2));

	}

	@Test
	public void testPotencias() {

		int resultado = (int) Math.pow(num1, num2);

		assertEquals(resultado, (int) operacion.potenciaExponente(num1, num2));
	}

}
