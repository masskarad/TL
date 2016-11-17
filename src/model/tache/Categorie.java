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
        categories_disponibles = new HashSet<String>(NOMBRE_CONSTANTE);
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
	 * @param p_valeur
	 */
	public Categorie(String p_valeur)
	{
		valeur = p_valeur;
	}

	/**
	 *
	 * @return
	 */
	public static Collection<String> getCategoriesDisponibles()
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
	 * @param p_nouvelle_categorie
	 */
	public static void addCategorieDisponible(String p_nouvelle_categorie)
	{
		categories_disponibles.add(p_nouvelle_categorie.toUpperCase());
	}

	/**
	 *
	 * @param p_ancienne_categorie
	 * @param p_nouvelle_categorie
	 */
	public static boolean renameCategorieDisponible(String p_ancienne_categorie, String p_nouvelle_categorie)
	{
		if(categories_disponibles.remove(p_ancienne_categorie.toUpperCase()))
			return categories_disponibles.add(p_nouvelle_categorie.toUpperCase());
		
		return false;
	}

	/**
	 *
	 * @param p_categorie_a_supprimer
	 */
	public static boolean removeCategorieDisponible(String p_categorie_a_supprimer)
	{
		if (autoriser(p_categorie_a_supprimer))
			return categories_disponibles.remove(p_categorie_a_supprimer.toUpperCase());
		
		return false;
	}

	/**
	 *
	 * @param p_string
	 * @return
	 */
	public static boolean autoriser(String p_string)
	{
		return !p_string.toUpperCase().equals(SANS_CATEGORIE) && !p_string.toUpperCase().equals(TRAVAIL) && !p_string.toUpperCase().equals(PERSONNEL);
	}
	
	@Override
	public String toString()
	{
		return valeur;
	}

	/**
	 *
	 */
	public static void afficherCategoriesDisponibles()
	{
		System.out.println(categories_disponibles.toString());
	}

	public static boolean containsCategoriesDisponibles(String p_categorie)
	{
		return categories_disponibles.contains(p_categorie.toUpperCase());
	}
	
	public static void main(String [] Args)
	{
		afficherCategoriesDisponibles();
		addCategorieDisponible("Yolo");
		addCategorieDisponible("Yolo");
		addCategorieDisponible("Yolo");
		afficherCategoriesDisponibles();
		renameCategorieDisponible("Yolo", "Titi");
		afficherCategoriesDisponibles();
		System.out.println(removeCategorieDisponible("SAns_caTEGorie"));
		System.out.println(getCategoriesDisponibles().contains("TITI"));
		afficherCategoriesDisponibles();
	}
}
