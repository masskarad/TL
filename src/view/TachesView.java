package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TachesView extends JPanel
{
	private JList<String> liste_taches;
	
	public TachesView()
	{
		setSize(new Dimension(700, 600));
		setBackground(Color.red);

		String[] data = {"one", "two", "three", "four"};
		liste_taches = new JList<String>(data);
		JScrollPane scrollPane = new JScrollPane(liste_taches);
		add(scrollPane, BorderLayout.CENTER);

		/*
		Tache t1 = new TachePonctuelle("Yolo");
		Tache t2 = new TachePonctuelle("Tarace");
		Tache t3 = new TachePonctuelle("Azerrze");
		ListeTache liste_tache_simple = new ListeTacheSimple();
		liste_tache_simple.add(t1);
		liste_tache_simple.add(t2);
		liste_tache_simple.add(t3);
		Object tabListe[] = liste_tache_simple.toArray();
		liste_taches = new JList(liste_tache_simple.toArray());

		add(liste_taches);
		*/
	}
}
