/**
 * Notation
 *    p_* : parametre
 *    t_* : variable tampon
 */

package model;

import java.util.HashSet;
import java.util.Iterator;

public class Categorie
{
	private static final String SANS_CATEGORIE   = "SANS_CATEGORIE";
	private static final String TRAVAIL          = "TRAVAIL";
	private static final String PERSONNEl        = "PERSONNEL";
	private static final int    NOMBRE_CONSTANTE = 3;
	
	private static HashSet<StringBuilder> categories;
	
	static
	{
		categories = new HashSet<StringBuilder>(NOMBRE_CONSTANTE);
		categories.add(new StringBuilder(SANS_CATEGORIE));
		categories.add(new StringBuilder(TRAVAIL));
		categories.add(new StringBuilder(PERSONNEl));
	}
	
	private String valeur;
	
	
	public Categorie()
	{
		valeur = SANS_CATEGORIE;
	}
	
	public Categorie(String p_categorie)
	{
		valeur = p_categorie;
	}
	
	public String getValeur()
	{
		return valeur;
	}
	
	public void setValeur(String p_valeur)
	{
		valeur = p_valeur;
	}
	
	public static void ajouter(String p_categorie)
	{
		categories.add(new StringBuilder(p_categorie.toUpperCase()));
	}
	
	public static void renommer(String p_ancienne_categorie, String p_nouvelle_categorie)
	{
		HashSet<StringBuilder> t_categories = new HashSet<StringBuilder>(categories.size());
		Iterator<StringBuilder> iterator = categories.iterator();
		while(iterator.hasNext())
		{
			StringBuilder temp = iterator.next();
			if(!temp.toString().equals(p_ancienne_categorie.toUpperCase()))
				t_categories.add(temp);
			else
				t_categories.add(new StringBuilder(p_nouvelle_categorie.toUpperCase()));
		}
		categories = new HashSet<StringBuilder>(t_categories);
	}
	
	public static void supprimer(String p_categorie)
	{
		StringBuilder temp = new StringBuilder();
		Iterator<StringBuilder> iterator = categories.iterator();
		while(iterator.hasNext())
		{
			temp = iterator.next();
			if(temp.toString().equals(p_categorie.toUpperCase()))
			{
				categories.remove(temp);
				return;
			}
		}
	}
	
	@Override
	public String toString()
	{
		return valeur;
	}
	
	public static void aff()
	{
		System.out.println(categories.toString());
	}
	
	public static void main(String [] Args)
	{
		Categorie categorie = new Categorie();
		aff();
		ajouter("Yolo");
		ajouter("YOlo");
		aff();
		renommer("Yolo", "Titi");
		aff();
		supprimer("SAns_caTEGorie");
		aff();
	}
}
