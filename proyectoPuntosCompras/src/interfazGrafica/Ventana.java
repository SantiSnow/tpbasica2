package interfazGrafica;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class Ventana extends JFrame{
	
	public JPanel nuevoPanel;
	
	public Ventana() {
		//este es el constructor de la ventana
		//siempre trabajamos con pixeles
		setSize(800, 500);		//tamaño de la ventana. ancho y alto respectivamente
		setTitle("Programa de Compras");		//setea el titulo de la ventana
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
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public void iniciarComponentes() {
		nuevoPanel = new JPanel();	//creamos el panel
		nuevoPanel.setLayout(null);		//establecemos el layout por defecto en null para poder cambiarlo luego
		this.getContentPane().add(nuevoPanel);	//agregamos el panel a la ventana
		nuevoPanel.setBackground(Color.DARK_GRAY);	//establece el color
		JLabel etiqueta1 = new JLabel("Bienvenido al programa de Compras", SwingConstants.CENTER);	//creamos una etiqueta
		JLabel etiqueta2 = new JLabel("Ingrese con su usario y contraseña:", SwingConstants.CENTER);	
		JLabel etiqueta3 = new JLabel("Si lo desea puede registrarse:", SwingConstants.CENTER);	
		//etiqueta1.setOpaque(true);
		/*
		 * si utilizamos el constructor sin parametros de JLabel, podemos agregarle luego texto
		 * usando etiqueta1.setText(" Bienvenido ");
		 */
		etiqueta1.setBounds(20, 10, 600, 40);	//establecemos el lugar y tamaño de la etiqueta
		etiqueta2.setBounds(20, 50, 600, 40);	
		etiqueta3.setBounds(20, 90, 600, 40);	
		etiqueta1.setForeground(Color.WHITE);	//establecemos el color de letra en blanco
		etiqueta2.setForeground(Color.WHITE);	
		etiqueta3.setForeground(Color.WHITE);	
		//etiqueta1.setBackground(Color.GREEN); 	no funciona si no usamos antes el metodo setOpaque(true); ahora comentado para que quede mejor
		etiqueta1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20)); 	//establecemos la fuente
		etiqueta2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		etiqueta3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 20));
		nuevoPanel.add(etiqueta1);	//agregamos la etiqueta al panel
		nuevoPanel.add(etiqueta2);
		nuevoPanel.add(etiqueta3);
		ImageIcon img1 = new ImageIcon("isologotipo.png");	//img
		JLabel etiquetaImg = new JLabel ();	//etiqueta sola
		etiquetaImg.setBounds(450, 20, 250, 200);	//le damos tamaño y seteamos el lugar
		etiquetaImg.setIcon(new ImageIcon(img1.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH)));
		nuevoPanel.add(etiquetaImg);	//agregamos al panel la imagen
		
	}
	
	public void agregarBotones() {
		JButton boton1 = new JButton("Ingresar");
		//si deseamos esto se puede hacer en un metodo boton1.setText("Ingresar");
		
		ActionListener oyente1 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaSegunda v1 = new VentanaSegunda();
				v1.setVisible(true);
			}
		};
		boton1.addActionListener(oyente1);
		
		JButton boton2 = new JButton("Registrarse");
		
		ActionListener oyente2 = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				VentanaTercera v3 = new VentanaTercera();
				v3.setVisible(true);
			}
		};
		boton2.addActionListener(oyente2);
		
		
		
		JButton boton3 = new JButton("Salir");
		
		ActionListener oyente3 = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		};
		boton3.addActionListener(oyente3);
		
		//boton3.setEnabled(false);  el boton funciona 
		boton1.setBounds(300, 150, 100, 40);
		nuevoPanel.add(boton1);
		boton1.setMnemonic(' ');
		boton1.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		boton2.setBounds(290, 250, 120, 40);
		nuevoPanel.add(boton2);
		boton2.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		boton3.setBounds(300, 350, 100, 40);
		nuevoPanel.add(boton3);
		boton3.setFont(new Font("Berlin Sans FB", Font.PLAIN, 15));
		
	}
	
}
