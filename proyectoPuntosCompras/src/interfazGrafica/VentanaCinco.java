package interfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class VentanaCinco extends JFrame{

public JPanel nuevoPanel;
	
	String nombreDeUsuario = "SantiagoSnow";
	String contraseña = "1234abcd";
	Long id = 458345834L;
	Integer puntosAcumulados = 5000;
	Boolean estado = true;
	
	public VentanaCinco() {
		//este es el constructor de la ventana que muestra solo los datos del usuario
		//siempre trabajamos con pixeles
		setSize(800, 500);		//tamaño de la ventana. ancho y alto respectivamente
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
		JLabel etiqueta1 = new JLabel("Estos son los datos del usuario:", SwingConstants.CENTER);	//creamos una etiqueta
		JLabel etiqueta2 = new JLabel("Nombre de Usuario: "+nombreDeUsuario, SwingConstants.CENTER);	
		JLabel etiqueta3 = new JLabel("Contraseña: "+contraseña, SwingConstants.CENTER);
		JLabel etiqueta4 = new JLabel("Numero de Id: "+id, SwingConstants.CENTER);
		JLabel etiqueta5 = new JLabel("Puntos acumulados: "+puntosAcumulados, SwingConstants.CENTER);
		//etiqueta1.setOpaque(true);
		/*
		 * si utilizamos el constructor sin parametros de JLabel, podemos agregarle luego texto
		 * usando etiqueta1.setText(" Bienvenido ");
		 */
		etiqueta1.setBounds(20, 10, 600, 40);	//establecemos el lugar y tamaño de la etiqueta
		etiqueta2.setBounds(20, 90, 600, 40);	
		etiqueta3.setBounds(20, 150, 600, 40);
		etiqueta4.setBounds(20, 200, 600, 40);
		etiqueta5.setBounds(20, 250, 600, 40);
		etiqueta1.setForeground(Color.WHITE);	//establecemos el color de letra en blanco
		etiqueta2.setForeground(Color.WHITE);	
		etiqueta3.setForeground(Color.WHITE);
		etiqueta4.setForeground(Color.WHITE);
		etiqueta5.setForeground(Color.WHITE);
		//etiqueta1.setBackground(Color.GREEN); 	no funciona si no usamos antes el metodo setOpaque(true); ahora comentado para que quede mejor
		etiqueta1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20)); 	//establecemos la fuente
		etiqueta2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		etiqueta3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		etiqueta4.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		etiqueta5.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		nuevoPanel.add(etiqueta1);	//agregamos la etiqueta al panel
		nuevoPanel.add(etiqueta2);
		nuevoPanel.add(etiqueta3);
		nuevoPanel.add(etiqueta4);
		nuevoPanel.add(etiqueta5);
		ImageIcon img1 = new ImageIcon("isologotipo.png");	//img
		JLabel etiquetaImg = new JLabel ();	//etiqueta sola
		etiquetaImg.setBounds(450, 20, 250, 200);	//le damos tamaño y seteamos el lugar
		etiquetaImg.setIcon(new ImageIcon(img1.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
		nuevoPanel.add(etiquetaImg);	//agregamos al panel la imagen
		
	}
	
	public void agregarBotones() {
		JButton boton3 = new JButton("Volver");
		boton3.setBounds(250, 350, 100, 40);
		nuevoPanel.add(boton3);
		boton3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		
		ActionListener oyente1 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaCuatro v4 = new VentanaCuatro();
				
				v4.setVisible(true);
			}
		};
		
		boton3.addActionListener(oyente1);
		
	}
}
