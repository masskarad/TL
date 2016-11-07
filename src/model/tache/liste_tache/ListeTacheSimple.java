package model.liste_tache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import model.tache.Tache;

public final class ListeTacheSimple implements Comparator<Tache>
{
	private List<Tache> liste_taches;
	
	public ListeTacheSimple()
	{
		liste_taches = new ArrayList<Tache>();
	}
	
	public ListeTacheSimple(Tache[] p_liste_taches)
	{
		liste_taches = Arrays.asList(p_liste_taches);
	}
	
	public void trier()
	{
		liste_taches.sort(this);
	}
	
	@Override
	public int compare(Tache p_tache_a, Tache p_tache_b)
	{
		return (int) (p_tache_a.getDate_limite().getMillis() - p_tache_b.getDate_limite().getMillis());
	}
	
	public static void main(String [] Args)
	{
	}
}
