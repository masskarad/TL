package model.tache.liste_tache;

import model.tache.Tache;
import model.tache.TachePonctuelle;

public final class ListeTacheSimple extends ListeTache
{

	public static void main(String [] Args) throws Exception
	{
		Tache t1 = new TachePonctuelle("Yolo");
		Tache t2 = new TachePonctuelle("Tarace");
		Tache t3 = new TachePonctuelle("Azerrze");
		Tache t4 = new TachePonctuelle("We");
		Tache t5 = t3;
		Tache t6 = new TachePonctuelle("We");
		ListeTache liste_tache_simple = new ListeTacheSimple();
		liste_tache_simple.add(t1);
		Thread.sleep(150);
		liste_tache_simple.add(t2);
		Thread.sleep(260);
		liste_tache_simple.add(t3);
		Thread.sleep(370);
		liste_tache_simple.add(t3);
		Thread.sleep(480);
		liste_tache_simple.add(t4);
		Thread.sleep(590);
		liste_tache_simple.add(t5);
		Thread.sleep(600);
		liste_tache_simple.add(t6);
		System.out.println(liste_tache_simple.toString());
		System.out.println("Taille : " + liste_tache_simple.size());
	}
}
