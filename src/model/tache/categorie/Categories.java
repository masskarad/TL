package model.tache.categorie;

import java.util.Map.Entry;

import org.joda.time.DateTime;

import java.util.TreeMap;

import model.tache.Tache;
import model.tache.TachePonctuelle;
import model.tache.liste_tache.ListeTache;
import model.tache.liste_tache.ListeTacheSimple;

public abstract class Categories
{
	private static final String TITRE_CATEGORIE_SANS_CATEGORIE = "SANS_CATEGORIE";
	private static final String TITRE_CATEGORIE_TRAVAIL        = "TRAVAIL";
	private static final String TITRE_CATEGORIE_PERSONNEL      = "PERSONNEL";
					
	private static TreeMap<CharSequence, ListeTache> categories;
	
	static
	{
		categories = new TreeMap<CharSequence, ListeTache>();
		categories.put(TITRE_CATEGORIE_SANS_CATEGORIE, new ListeTacheSimple());
		categories.put(TITRE_CATEGORIE_TRAVAIL, new ListeTacheSimple());
		categories.put(TITRE_CATEGORIE_PERSONNEL, new ListeTacheSimple());
	}
	
	public Categories()
	{
		categories = new TreeMap<CharSequence, ListeTache>();
	}
	
	public static void ajouterCategorie(String p_nouvelle_categorie) throws Exception
	{
		if(!autoriser(p_nouvelle_categorie) || !autoriser(p_nouvelle_categorie))
			throw new Exception();
		
		if(categories.get(p_nouvelle_categorie) != null)
			throw new Exception();
		
		categories.put(p_nouvelle_categorie, new ListeTacheSimple());
	}
	
	public static void supprimerCategorie(String p_categorie) throws Exception
	{
		if(!autoriser(p_categorie) || !autoriser(p_categorie))
			throw new Exception();
		
		if(categories.get(p_categorie) == null)
			throw new Exception();
		
		ListeTache t_liste_tache_simple = categories.get(p_categorie.toUpperCase());
		categories.remove(p_categorie.toUpperCase());
		categories.get(TITRE_CATEGORIE_SANS_CATEGORIE).addAll(t_liste_tache_simple);
	}
	
	public static void renommerCategorie(String p_ancienne_categorie, String p_nouvelle_categorie) throws Exception
	{
		if((!autoriser(p_ancienne_categorie) || !autoriser(p_ancienne_categorie)) ||
				(!autoriser(p_nouvelle_categorie) || !autoriser(p_nouvelle_categorie)))
			throw new Exception();
		
		if(categories.get(p_ancienne_categorie) == null)
			throw new Exception();
		
		if(categories.get(p_nouvelle_categorie) != null)
			throw new Exception();
		
		ListeTache t_liste_tache_simple = new ListeTacheSimple();
		t_liste_tache_simple.addAll(categories.get(p_ancienne_categorie.toUpperCase()));
		categories.put(p_nouvelle_categorie.toUpperCase(), t_liste_tache_simple);
		categories.remove(p_ancienne_categorie);
	}
	
	public static CharSequence getCategorie(Tache p_tache)
	{
		for (Entry<CharSequence, ListeTache> e : categories.entrySet())
			if(e.getValue().contains(p_tache))
				return e.getKey();
		
		return null;
	}
	
	public static boolean autoriser(String p_categorie)
	{
		return (!p_categorie.equals(TITRE_CATEGORIE_SANS_CATEGORIE) && 
				!p_categorie.equals(TITRE_CATEGORIE_TRAVAIL) &&
				!p_categorie.equals(TITRE_CATEGORIE_PERSONNEL));
	}
	
	public static void main(String [] Args) throws Exception
	{	
		DateTime date1 = new DateTime().plusDays(1);
		DateTime date2 = new DateTime().plusDays(2);
		DateTime date3 = new DateTime().plusDays(3);
		DateTime date4 = new DateTime().plusDays(4);
		
		Tache c1 = new TachePonctuelle(date1);
		Tache c2 = new TachePonctuelle(date2);
		Tache c3 = new TachePonctuelle(date3);
		Tache c4 = new TachePonctuelle(date4);
		
		ListeTache lt1 = new ListeTacheSimple();
		ListeTache lt2 = new ListeTacheSimple();
		
		lt1.add(c1);
		lt1.add(c2);
		lt1.add(c3);
		
		lt2.add(c4);
		
		categories.put(TITRE_CATEGORIE_TRAVAIL, lt1);
		categories.put(TITRE_CATEGORIE_PERSONNEL, lt2);
		
		//System.out.println(categories.toString());
		
		System.out.println(getCategorie(c1));
		System.out.println(getCategorie(c2));
		System.out.println(getCategorie(c3));
		System.out.println(getCategorie(c4));
		
		supprimerCategorie(TITRE_CATEGORIE_TRAVAIL);
		
		System.out.println("-----------------------------");
		
		System.out.println(getCategorie(c1));
		
		renommerCategorie(TITRE_CATEGORIE_PERSONNEL, "Yolo");
		System.out.println(getCategorie(c4));
		
		System.out.println("-----------------------------");
		
		System.out.println(categories.toString());
		
		categories.put(TITRE_CATEGORIE_SANS_CATEGORIE, new ListeTacheSimple());
		
		System.out.println("-----------------------------");
		
		System.out.println(categories.toString());
	}

}
