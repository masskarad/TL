package model.tache;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.joda.time.DateTime;

import model.Categorie;

public abstract class Tache implements Serializable
{
	private static final long serialVersionUID = -2452413728288347395L;

	private final static String SANS_TITRE = "SANS_TITRE";
	
	private String titre;
	private Categorie categorie;
	private byte avencement;
	private DateTime date_limite;
	
	public Tache()
	{
		titre       = SANS_TITRE;
		categorie   = new Categorie();
		avencement  = 0;
		date_limite = DateTime.now();
	}
	
	public Tache(String p_titre)
	{
		titre       = p_titre;
		categorie   = new Categorie();
		avencement  = 0;
		date_limite = DateTime.now();
	}
	
	public Tache(DateTime p_date_limite)
	{
		titre       = SANS_TITRE;
		categorie   = new Categorie();
		avencement  = 0;
		date_limite = p_date_limite;
	}
	
	public Tache(String p_titre, String p_categorie, DateTime p_date_limite)
	{
		titre       = p_titre;
		categorie   = new Categorie(p_categorie);
		avencement  = 0;
		date_limite = p_date_limite;
	}
	
	public final void setTitre(String p_nouveau_titre)
	{
		titre = p_nouveau_titre;
	}
	
	public final void setCategorie(String p_nouvelle_categorie)
	{
		categorie.setValeur(p_nouvelle_categorie);
	}
	
	public final String getTitre()
	{
		return titre;
	}
	
	public final Categorie getCategorie()
	{
		return categorie;
	}
	
	public final int getAvencement()
	{
		return avencement;
	}
	
	public final DateTime getDate_limite()
	{
		return date_limite;
	}
	
	public abstract boolean estEnRetard();
	
	public static void main(String [] Args)
	{
		try
		{
			Tache tache = new TacheAuLong(DateTime.now());
			tache.avencement = 42;
			FileOutputStream fileOut = new FileOutputStream("/home/harkame/tache.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(tache);
			out.close();
			fileOut.close();
			
			
			FileInputStream fileIn = new FileInputStream("/home/harkame/tache.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			Tache tache2 = (Tache) in.readObject();
			in.close();
			fileIn.close();
			System.out.println("Tache2 : " + tache2.avencement);
		}
		catch(Exception exception)
		{
			
		}
	}
}
