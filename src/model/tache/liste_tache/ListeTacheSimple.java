package model.tache.liste_tache;

import java.util.TreeSet;

import model.tache.Tache;
import model.tache.TachePonctuelle;

public final class ListeTacheSimple extends ListeTache
{
	@Override
	public int compare(Tache p_tache_a, Tache p_tache_b)
	{
		return (int) p_tache_a.getDate_limite().getMillis() - (int) p_tache_b.getDate_limite().getMillis();
	}

	public static void main(String [] Args)
	{
		Tache t1 = new TachePonctuelle("Yolo");
		Tache t2 = new TachePonctuelle("Tarace");
		Tache t3 = new TachePonctuelle("Azerrze");
		Tache t4 = t3;
		ListeTacheSimple liste_tache_simple = new ListeTacheSimple();
		liste_tache_simple.add(t1);
		liste_tache_simple.add(t2);
		//liste_tache_simple.add(t3);
		liste_tache_simple.add(t3);
		liste_tache_simple.add(t4);
		System.out.println(liste_tache_simple.toString());
		System.out.println("Taille : " + liste_tache_simple.size());
	}
}
