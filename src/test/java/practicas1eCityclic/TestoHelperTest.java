package practicas1eCityclic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ecityclic.practicas1eCityclic.beans.Persona;
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
	
