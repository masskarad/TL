package view;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuView extends JPanel
{
	JButton taches;
	JButton categories;
	JButton menu;
	
	public MenuView()
	{
		setPreferredSize(new Dimension(100, 600));
		setLayout(null);
		menu = new JButton("Menu");
		taches = new JButton("Taches");
		categories = new JButton("Categories");
		add(menu);
		add(taches);
		add(categories);
		menu.setPreferredSize(new Dimension(80, 50));
		taches.setPreferredSize(new Dimension(80, 50));
		categories.setPreferredSize(new Dimension(80, 50));
		Insets insets = getInsets();
	    Dimension size = menu.getPreferredSize();
	    menu.setBounds(10 + insets.left, 75 + insets.top,
	             size.width, size.height);
	    size = taches.getPreferredSize();
	    taches.setBounds(10 + insets.left, 250 + insets.top,
	             size.width, size.height);
	    size = categories.getPreferredSize();
	    categories.setBounds(10 + insets.left, 425 + insets.top,
	             size.width, size.height);
	}
}
