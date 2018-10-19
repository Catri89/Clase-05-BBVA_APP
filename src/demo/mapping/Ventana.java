package demo.mapping;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Ventana extends JFrame
{
	private JTextField tfNombre;

	public Ventana()
	{
		getContentPane().setLayout(null);

		JLabel lblNombre=new JLabel("Nombre");
		lblNombre.setBounds(10,11,46,14);
		getContentPane().add(lblNombre);

		tfNombre=new JTextField();
		tfNombre.setBounds(66,8,259,20);
		getContentPane().add(tfNombre);
		tfNombre.setColumns(10);

		JButton bAceptar=new JButton("Aceptar");
		bAceptar.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				String nom = tfNombre.getText();
				System.out.println(nom);
				
			}
		});
		bAceptar.setBounds(335,7,89,23);
		getContentPane().add(bAceptar);
	}
	
	public static void main(String[] args)
	{
		Ventana v = new Ventana();
		v.setSize(450,300);
		v.setVisible(true);
		
	}
}