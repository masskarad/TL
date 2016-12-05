package view;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DefaultView extends JFrame
{
	private JButton button;
	private JPanel menu;
	private JPanel gauche;
	
	public DefaultView()
	{
	    setSize(800, 600);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             
	    setVisible(true);
	    menu = new MenuView();
	    add(menu, "East");
	    gauche = new TachesView();
	    add(gauche, "West");
	}
	
	public JButton getButton()
	{
		return button;
	}
	
	public static void main(String[] args)
	{
		DefaultView hv = new DefaultView();
	}  
	
	
}
