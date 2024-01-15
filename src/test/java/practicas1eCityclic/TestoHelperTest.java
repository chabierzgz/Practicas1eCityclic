package practicas1eCityclic;

import static org.junit.Assert.*;

import org.junit.Test;

import com.ecityclic.practicas1eCityclic.helper.TextoHelper;

public class TestoHelperTest {

	@Test
	public void test() {
		TextoHelper textoHelper = new TextoHelper();
		assertNotNull(textoHelper.generaFecha());
		
	}

}
