package Test;

import javax.swing.JOptionPane;

import org.junit.AfterClass;
import org.junit.BeforeClass;

public class TestSistema {
	@BeforeClass
	public static void avisoInicioDeLosTest() {
		JOptionPane.showMessageDialog(null, "El test del Sistema ha comenzado correctamente");
	}
	
	@AfterClass
	public static void avisoFinDeLosTest() {
		JOptionPane.showMessageDialog(null, "El test del Sistema ha finalizado, compruebe los resultados");
	}
}
