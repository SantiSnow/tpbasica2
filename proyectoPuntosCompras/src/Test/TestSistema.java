package Test;

import javax.swing.JOptionPane;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import usuario.Administrador;
import usuario.Cliente;
import src.Compra;
import src.Producto;
import src.Sistema;
import src.Usuario;

public class TestSistema {
	@BeforeClass
	public static void avisoInicioDeLosTest() {
		JOptionPane.showMessageDialog(null, "El test del Sistema ha comenzado correctamente");
	}
	
	@AfterClass
	public static void avisoFinDeLosTest() {
		JOptionPane.showMessageDialog(null, "El test del Sistema ha finalizado, compruebe los resultados");
	}
	
	@Test
	public void testeoCreacionDeUsuariosYRegistro() {
		//creamos objetos
		Sistema sistema1 = new Sistema ("sistema1");
		Usuario admin1 = new Administrador("admin1", "1234abcd", 638468L, 9000, false);
		Usuario cliente1 = new Cliente("cliente1", "1234abcd", 638321L, 100, false);
		//los agregamos a la lista
		Assert.assertTrue(sistema1.agregaUnUsuarioAlSistema(admin1));
		Assert.assertTrue(sistema1.agregaUnUsuarioAlSistema(cliente1));
		//testeamos que no puedan agregarse repetidos
		Assert.assertFalse(sistema1.agregaUnUsuarioAlSistema(admin1));
		Assert.assertFalse(sistema1.agregaUnUsuarioAlSistema(cliente1));
	}
	
	@Test
	public void testeoParaCrearObjetosYObtenerTamañoDeLasListas() {
		//creamos objetos
		Sistema sistema1 = new Sistema ("sistema1");
		Usuario admin1 = new Administrador("admin1", "1234abcd", 638468L, 9000, false);
		Usuario cliente1 = new Cliente("cliente1", "1234abcd", 638321L, 100, false);
		
		Assert.assertTrue(sistema1.agregaUnUsuarioAlSistema(admin1));
		Assert.assertTrue(sistema1.agregaUnUsuarioAlSistema(cliente1));
		
		//conocer la cantidad de usuarios
		Assert.assertEquals(2, sistema1.conocerTamañoDelSistemaDeUsuarios(), 0.0);
	}
	
	@Test
	public void testParaProbarLaVentadeProductos1() {
		//creamos los usuarios para meterlos al sistema
		Sistema sistema1 = new Sistema ("sistema1");
		Usuario admin1 = new Administrador("admin1", "1234abcd", 638468L, 9000, false);
		Usuario cliente1 = new Cliente("cliente1", "1234abcd", 638321L, 100, false);
		
		Producto producto1 = new Producto ("Milanesas", 324234L, 500.0);
		Producto producto2 = new Producto ("Milanesas", 324234L, 500.0);
		Producto producto3 = new Producto ("Milanesas", 324234L, 500.0);
		
		sistema1.agregaUnUsuarioAlSistema(admin1);
		sistema1.agregaUnUsuarioAlSistema(cliente1);
		
		//creamos una compra nueva
		Compra compra1 = new Compra (85449L, cliente1);
		Assert.assertTrue(compra1.agregarProductoALaCompra(producto1));
		Assert.assertTrue(compra1.agregarProductoALaCompra(producto2));
		Assert.assertTrue(compra1.agregarProductoALaCompra(producto3));
	}
	
	@Test
	public void testParaPorbarLaMuestraDeProducto() {
		Sistema sistema1 = new Sistema ("sistema1");
		Usuario admin1 = new Administrador("admin1", "1234abcd", 638468L, 9000, false);
		Usuario cliente1 = new Cliente("cliente1", "1234abcd", 638321L, 100, false);
		
		Producto producto1 = new Producto ("Gaseosa", 3484854L, 600.0);
		Producto producto2 = new Producto ("Jugo", 1234141L, 600.0);
		
		sistema1.agregarProductoAlSistema(producto1);
		sistema1.agregarProductoAlSistema(producto2);
		
		sistema1.mostrarLosProductos();
	}
	
}
