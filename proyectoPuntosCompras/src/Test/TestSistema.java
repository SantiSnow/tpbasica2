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
	public void testeoCreacionDeUsuariosYRegistroYeliminacionTrue() {
		//creamos objetos
		Sistema sistema1 = new Sistema ("sistema1");
		Usuario admin1 = new Administrador("admin1", "1234abcd", 638468L, 9000, false);
		Usuario cliente1 = new Cliente("cliente1", "1234abcd", 638321L, 100, false);
		//los agregamos a la lista
		Assert.assertTrue(sistema1.agregaUnUsuarioAlSistema(admin1));
		Assert.assertTrue(sistema1.agregaUnUsuarioAlSistema(cliente1));
		//Testeo de eliminar un usuario
		Assert.assertTrue(sistema1.eliminarUsuario("cliente1"));
	}
	@Test
	public void testeoNoDejarRegistrarUsuariosRepetidos() {
		//creamos objetos
		Sistema sistema1 = new Sistema ("sistema1");
		Usuario admin1 = new Administrador("admin1", "1234abcd", 638468L, 9000, false);
		Usuario cliente1 = new Cliente("cliente1", "1234abcd", 638321L, 100, false);
		//Agregamo usuario para verificar posteriormente
		sistema1.agregaUnUsuarioAlSistema(cliente1);
		sistema1.agregaUnUsuarioAlSistema(admin1);
		//testeamos que no puedan agregarse repetidos
		Assert.assertFalse(sistema1.agregaUnUsuarioAlSistema(admin1));
		Assert.assertFalse(sistema1.agregaUnUsuarioAlSistema(cliente1));
		
	}

	@Test
	public void testeoEncontrarUsuario() {
		Sistema sistema1 = new Sistema ("sistema1");
		Usuario admin1 = new Administrador("admin1", "1234abcd", 638468L, 9000, false);
		Usuario cliente1 = new Cliente("cliente1", "1234abcd", 638321L, 100, false);
		//los agregamos a la lista
		Assert.assertTrue(sistema1.agregaUnUsuarioAlSistema(admin1));
		Assert.assertTrue(sistema1.agregaUnUsuarioAlSistema(cliente1));
		
		Assert.assertEquals(sistema1.retornarElObjetoUsuario("admin1", "1234abcd"), admin1);
	}

	
	@Test
	public void testeoParaCrearObjetosYObtenerTama�oDeLasListas() {
		//creamos objetos
		Sistema sistema1 = new Sistema ("sistema1");
		Usuario admin1 = new Administrador("admin1", "1234abcd", 638468L, 9000, false);
		Usuario cliente1 = new Cliente("cliente1", "1234abcd", 638321L, 100, false);
		
		Assert.assertTrue(sistema1.agregaUnUsuarioAlSistema(admin1));
		Assert.assertTrue(sistema1.agregaUnUsuarioAlSistema(cliente1));
		
		//conocer la cantidad de usuarios
		Assert.assertEquals(2, sistema1.conocerTama�oDelSistemaDeUsuarios(), 0.0);
	}
	
	@Test
	public void testeoEncontrarUsuarioFalse() {
		Sistema sistema1 = new Sistema ("sistema1");
		Usuario admin1 = new Administrador("admin1", "1234abcd", 638468L, 9000, false);
		Usuario cliente1 = new Cliente("cliente1", "1234abcd", 638321L, 100, false);
		Usuario cliente2 = new Cliente("cliente2", "1234abcd", 634789L, 100, false);

		//Solamente agregamos dos usuarios a la lista
		sistema1.agregaUnUsuarioAlSistema(admin1);
		sistema1.agregaUnUsuarioAlSistema(cliente1);
		//Testeo para comprobar que cliente2 no se encuentra en el sistema
		Assert.assertFalse(sistema1.loggearseComoUsuario("cliente2", "1234abcd"));	
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
	public void testParaVerificarTransaccionDePago() {
		Sistema sistema1 = new Sistema ("sistema1");
		Usuario admin1 = new Administrador("admin1", "1234abcd", 638468L, 9000, false);
		Usuario cliente1 = new Cliente("cliente1", "1234abcd", 638321L, 100, false);
		
		Producto producto1 = new Producto ("Milanesas", 324234L, 500.0);
		Producto producto2 = new Producto ("Milanesas", 324234L, 500.0);
		Producto producto3 = new Producto ("Fernet", 326234L, 700.0);
		
		sistema1.agregaUnUsuarioAlSistema(admin1);
		sistema1.agregaUnUsuarioAlSistema(cliente1);
		sistema1.agregarProductoAlSistema(producto2);
		
		sistema1.loggearseComoUsuario("cliente1", "1234abcd");
		
		//Verificamos que el valor de los productos sea correcta
		Assert.assertEquals(500.0, sistema1.realizarUnaCompra(cliente1, producto2), 0.0);
		//Verificamos que el pago ha sido realizado
		Assert.assertEquals("Gracias por su compra, el producto esta en camino!", sistema1.pagarEnEfectivo(500.0d));
		
		sistema1.realizarUnaCompra(admin1, producto3);
		
		//Verificamos que se pueda pagar con puntos
		Assert.assertTrue(sistema1.pagarConPuntos(admin1, 700.0d));
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
	
	@Test
	public void testLoggeoYsalirDelSistema() {
		//Creamos el sistema y los usuarios para la prueba
		Sistema sistema1 = new Sistema ("sistema1");
		Usuario admin1 = new Administrador("admin1", "1234abcd", 638468L, 9000, false);
		Usuario cliente1 = new Cliente("cliente1", "1234abcd", 638321L, 100, false);
		
		//Agregamos los usuarios al sistema
		sistema1.agregaUnUsuarioAlSistema(admin1);
		sistema1.agregaUnUsuarioAlSistema(cliente1);
		
		//Devuelve un true si es que se loggean con exito
		Assert.assertTrue(sistema1.loggearseComoUsuario("admin1", "1234abcd"));
		Assert.assertTrue(sistema1.loggearseComoUsuario("cliente1", "1234abcd"));
		//Devuelve un true si es que salen del sistema con exito
		Assert.assertTrue(sistema1.salirDelSistema("admin1", "1234abcd"));
		Assert.assertTrue(sistema1.salirDelSistema("cliente1", "1234abcd"));
	}
	
	@Test
	public void testLoggeoYsalirDelSistemaFalse() {
		//Creamos el sistema y los usuarios para la prueba
		Sistema sistema1 = new Sistema ("sistema1");
		Usuario admin1 = new Administrador("admin1", "1234abcd", 638468L, 9000, false);
		Usuario cliente1 = new Cliente("cliente1", "1234abcd", 638321L, 100, false);
				
		//Agregamos los usuarios al sistema
		sistema1.agregaUnUsuarioAlSistema(admin1);
		sistema1.agregaUnUsuarioAlSistema(cliente1);
		
		//Devuelve un false, por ingresar mal datos y/o contrase�as
		//Primero colocamos mal el usuario
		Assert.assertFalse(sistema1.loggearseComoUsuario("Admin2", "1234abcd"));
		//Segundo colocamos mal la contrase�a
		Assert.assertFalse(sistema1.loggearseComoUsuario("cliente1", "1134abcd"));
		
		//Loggeamos correctamente, para verificar si cierran mal la sesion
		Assert.assertTrue(sistema1.loggearseComoUsuario("admin1", "1234abcd"));
		Assert.assertTrue(sistema1.loggearseComoUsuario("cliente1", "1234abcd"));
		
		//Primero colocamos el usuario incorrecto
		Assert.assertFalse(sistema1.salirDelSistema("Admin2", "1234abcd"));
		//Segundo colocamos una contrase�a incorrecta
		Assert.assertFalse(sistema1.salirDelSistema("cliente1", "1134abcd"));
		
	}
	
	@Test
	public void testVaciamientoDeListaUsuarios() {
		Sistema sistema1 = new Sistema ("sistema1");
		Usuario admin1 = new Administrador("admin1", "1234abcd", 638468L, 9000, false);
		Usuario cliente1 = new Cliente("cliente1", "1234abcd", 638321L, 100, false);
		
		sistema1.agregaUnUsuarioAlSistema(admin1);
		sistema1.agregaUnUsuarioAlSistema(cliente1);
		
		//Verificamos que la lista contiene usuarios
		Assert.assertEquals(2, sistema1.conocerTama�oDelSistemaDeUsuarios(), 0.0);
		
		//Vaciamos la lista
		sistema1.vaciarListaDeUsuarios();
		//Verificamos que la lista se encuentre vacia
		Assert.assertEquals(0, sistema1.conocerTama�oDelSistemaDeUsuarios(), 0.0);
	}
}
