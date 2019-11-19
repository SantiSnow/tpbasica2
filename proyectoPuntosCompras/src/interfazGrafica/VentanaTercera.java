package interfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class VentanaTercera extends JFrame{
	//ventana de registro
	public JPanel nuevoPanel;
	
	public VentanaTercera() {
		//ventana de registro
		//este es el constructor de la ventana
		//siempre trabajamos con pixeles
		setSize(800, 500);		//tama�o de la ventana. ancho y alto respectivamente
		setTitle("Programa de Prueba");		//setea el titulo de la ventana
		setLocation(10, 10); 	//seteamos la ubicacion inicial de la ventana
		
		/*
		 * int x = 10;
		 * int y = 10;
		 * int width = 500; 
		 * int height = 500;
		 * 
		setBounds(x, y, width, height);
		
		 * en este metodo, englobamos los metodos setLocation y setSize en uno solo
		 * indicando primero la ubicacion x, luego y, luego el ancho y el largo.
		 * se comenta porque no podemos tener steBounds() declarado junto con setSize y setLocation
		 * 
		 * setLocationRelativeTo(null); ubica la ventana justo en el centro de la pantalla al inicio,
		 * deberiamos comentar setLocation() y setBounds(); para usarlo
		*/
		
		this.getContentPane().setBackground(Color.BLACK);
		iniciarComponentes();
		agregarBotones();
		setDefaultCloseOperation(EXIT_ON_CLOSE);	//setea que termine el programa al cerrar la ventana
		
	}
	
	public void iniciarComponentes() {
		nuevoPanel = new JPanel();	//creamos el panel
		nuevoPanel.setLayout(null);		//establecemos el layout por defecto en null para poder cambiarlo luego
		this.getContentPane().add(nuevoPanel);	//agregamos el panel a la ventana
		nuevoPanel.setBackground(Color.DARK_GRAY);	//establece el color
		JLabel etiqueta1 = new JLabel("Para registrarse, ingrese usuario y contrase�a: ", SwingConstants.CENTER);	//creamos una etiqueta
		//etiqueta1.setOpaque(true);
		/*
		 * si utilizamos el constructor sin parametros de JLabel, podemos agregarle luego texto
		 * usando etiqueta1.setText(" Bienvenido ");
		 */
		etiqueta1.setBounds(20, 10, 600, 40);	//establecemos el lugar y tama�o de la etiqueta
		etiqueta1.setForeground(Color.WHITE);	//establecemos el color de letra en blanco	
		//etiqueta1.setBackground(Color.GREEN); 	no funciona si no usamos antes el metodo setOpaque(true); ahora comentado para que quede mejor
		etiqueta1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20)); 	//establecemos la fuente
		nuevoPanel.add(etiqueta1);	//agregamos la etiqueta al panel
		ImageIcon img1 = new ImageIcon("isologotipo.png");	//img
		JLabel etiquetaImg = new JLabel ();	//etiqueta sola
		etiquetaImg.setBounds(450, 20, 250, 200);	//le damos tama�o y seteamos el lugar
		etiquetaImg.setIcon(new ImageIcon(img1.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
		nuevoPanel.add(etiquetaImg);	//agregamos al panel la imagen
		
		//colocamos cajas de texto de unica linea
		JTextField cajaText1 = new JTextField("Usuario nuevo");
		cajaText1.setBounds(250, 60, 150, 50);
		nuevoPanel.add(cajaText1);
		JTextField cajaText2 = new JTextField("Contrase�a");
		cajaText2.setBounds(250, 130, 150, 50);
		nuevoPanel.add(cajaText2);
		
		JTextField cajaText3 = new JTextField("Repita la contrase�a");
		cajaText3.setBounds(250, 200, 150, 50);
		nuevoPanel.add(cajaText3);
		
		//capturamos los inputs en las cajas
		String usuarioIngresado;
		String contrase�aIngresada;
				
	}
	
	public void agregarBotones() {
		JButton boton3 = new JButton("Registrarse");
		
		ActionListener oyente1 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaNueve v9 = new VentanaNueve();
				
				v9.setVisible(true);
			}
		};
		
		boton3.addActionListener(oyente1);
		
		boton3.setBounds(250, 280, 100, 40);
		nuevoPanel.add(boton3);
		boton3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		
	}
	
}