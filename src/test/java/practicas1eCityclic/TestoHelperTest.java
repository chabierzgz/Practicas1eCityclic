package practicas1eCityclic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.ecityclic.practicas1eCityclic.helper.TextoHelper;

public class TestoHelperTest {

	
	TextoHelper textoHelper = new TextoHelper();
	
	@Test
	public void testGeneraFecha() {
		
		assertNotNull(textoHelper.generaFecha());
			
	}
	
	@Test
	public void testGetPersonas() {
		
		assertEquals(3, textoHelper.getPersonas(3).size());
		
			
	}
}
	
