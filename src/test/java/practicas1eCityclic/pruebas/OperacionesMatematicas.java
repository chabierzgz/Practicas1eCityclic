package practicas1eCityclic.pruebas;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ecityclic.practicas1eCityclic.helper.Operaciones;

public class OperacionesMatematicas {

<<<<<<< Updated upstream
=======
	Operaciones operacion = new Operaciones();
	
	int num1 = (int) (Math.random() * 10);
	int num2 = (int) (Math.random() * 10);
	
			

>>>>>>> Stashed changes
	@Test
	public void test() {
		Operaciones operacion = new Operaciones();
		
<<<<<<< Updated upstream
		
	}

=======
		assertEquals(num1+num2, operacion.suma(num1, num2));

	}

	@Test
	public void testResta() {
		
		int resultado=num1-num2;

		assertEquals(resultado, operacion.resta(num1, num2));

	}

	@Test
	public void testMultiplica() {
		
		int resultado=num1*num2;

		assertEquals(resultado, operacion.multiplica(num1, num2));

	}

	@Test
	public void testPotencias() {
		
		int resultado=(int)Math.pow(num1, num2);

		assertEquals(resultado, (int)operacion.potenciaExponente(num1, num2));

	}
>>>>>>> Stashed changes
}
