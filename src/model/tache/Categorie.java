package model.tache;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Categorie
{
	private static final String SANS_CATEGORIE   = "SANS_CATEGORIE";
	private static final String TRAVAIL          = "TRAVAIL";
	private static final String PERSONNEL        = "PERSONNEL";
	private static final int    NOMBRE_CONSTANTE = 3;
	
	private static Collection<String> categories_disponibles;
	
	static
	{
		categories_disponibles = new HashSet<>(NOMBRE_CONSTANTE);
		categories_disponibles.add(SANS_CATEGORIE);
		categories_disponibles.add(TRAVAIL);
		categories_disponibles.add(PERSONNEL);
	}
	
	private String valeur;

	/**
	 *
	 */
	public Categorie()
	{
		valeur = SANS_CATEGORIE;
	}

	/**
	 *
	 * @param p_categorie
	 */
	public Categorie(String p_categorie)
	{
		valeur = p_categorie;
	}

	/**
	 *
	 * @return
	 */
	public Collection getCategories_disponibles()
	{
		return categories_disponibles;
	}

	/**
	 *
	 * @return
	 */
	public String getValeur()
	{
		return valeur;
	}

	/**
	 *
	 * @param p_valeur
	 */
	public void setValeur(String p_valeur)
	{
		valeur = p_valeur;
	}

	/**
	 *
	 * @param p_categorie
	 */
	public static void ajouter(String p_categorie)
	{
		categories_disponibles.add(p_categorie.toUpperCase());
	}

	/**
	 *
	 * @param p_ancienne_categorie
	 * @param p_nouvelle_categorie
	 */
	public static void renommer(String p_ancienne_categorie, String p_nouvelle_categorie)
	{
		HashSet<String> t_categories = new HashSet<>(categories_disponibles.size());
		Iterator<String> iterator = categories_disponibles.iterator();
		while(iterator.hasNext())
		{
			String temp = iterator.next();
			if(!temp.toString().equals(p_ancienne_categorie.toUpperCase()))
				t_categories.add(temp);
			else
				t_categories.add(p_nouvelle_categorie.toUpperCase());
		}
		categories_disponibles = new HashSet<>(t_categories);
	}

	/**
	 *
	 * @param p_categorie
	 */
	public static void supprimer(String p_categorie)
	{
		String temp;
		Iterator<String> iterator = categories_disponibles.iterator();
		while(iterator.hasNext())
		{
			temp = iterator.next();
			if(temp.toString().equals(p_categorie.toUpperCase()))
			{
				categories_disponibles.remove(temp);
				return;
			}
		}
	}

	/**
	 *
	 * @param p_string
	 * @return
	 */
	public static boolean autoriser(String p_string)
	{
		return !p_string.equals(SANS_CATEGORIE) && !p_string.equals(TRAVAIL) && !p_string.equals(PERSONNEL);
	}
	
	@Override
	public String toString()
	{
		return valeur;
	}

	/**
	 *
	 */
	public static void afficherCategories_disponibles()
	{
		System.out.println(categories_disponibles.toString());
	}

	/**
	 *
	 * @param p_categorie
	 * @return
	 */
	public boolean existe(String p_categorie)
	{
		Iterator<String> iterator = categories_disponibles.iterator();
		while(iterator.hasNext())
			if(iterator.next().equals(p_categorie))
				return true;
		return false;
	}
	
	public static void main(String [] Args)
	{
		afficherCategories_disponibles();
		ajouter("Yolo");
		ajouter("Yolo");
		ajouter("Yolo");
		afficherCategories_disponibles();
		renommer("Yolo", "Titi");
		afficherCategories_disponibles();
		supprimer("SAns_caTEGorie");
		afficherCategories_disponibles();
	}
}
