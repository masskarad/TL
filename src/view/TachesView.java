package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.tache.Tache;
import model.tache.TachePonctuelle;
import model.tache.liste_tache.ListeTache;
import model.tache.liste_tache.ListeTacheSimple;

public class TachesView extends JPanel
{
	private JList<String> liste_taches;
	
	public TachesView()
	{
		setSize(new Dimension(660, 600));
		setBackground(Color.red);
		Tache t1 = new TachePonctuelle("Yolo");
		Tache t2 = new TachePonctuelle("Tarace");
		Tache t3 = new TachePonctuelle("Azerrze");
		ListeTache liste_tache_simple = new ListeTacheSimple();
		liste_tache_simple.add(t1);
		liste_tache_simple.add(t2);
		liste_tache_simple.add(t3);
		String[] tabListe = new String[liste_tache_simple.toArray().length];
    	StringBuilder string_builder = new StringBuilder();
    	int i=0;
    	Iterator<Tache> iterator =  liste_tache_simple.iterator();
	   	while(iterator.hasNext())
	   	{
	   		tabListe[i]=iterator.next().toString();
	   		i++;
	   	}
	   		
		liste_taches = new JList<String>(tabListe);

		JScrollPane scrollPane = new JScrollPane(liste_taches);
		add(scrollPane);
		scrollPane.setPreferredSize(new Dimension(500, 500));
		Insets insets = getInsets();
	    Dimension size = scrollPane.getPreferredSize();
	    scrollPane.setBounds(80 + insets.left, 50 + insets.top,
	             size.width, size.height);

	}
}
