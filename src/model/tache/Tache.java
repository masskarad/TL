package model.tache;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import annotation.TLTest;
import annotation.TLTest.STATUS;

import org.joda.time.DateTime;

@SuppressWarnings("serial")
public abstract class Tache implements Serializable, Comparable<Tache>
{
	private final static String SANS_TITRE = "SANS_TITRE";

	private String    titre;
	private byte      avencement;
	private DateTime  date_limite;
	
	@TLTest(status = STATUS.TESTED)
	public Tache()
	{
		titre       = SANS_TITRE;
		avencement  = 0;
		date_limite = DateTime.now().plusDays(1);
	}
	
	@TLTest(status = STATUS.TESTED)
	public Tache(String p_titre)
	{
		titre       = p_titre;
		avencement  = 0;
		date_limite = DateTime.now().plusDays(1);
	}
	
	@TLTest(status = STATUS.TESTED)
	public Tache(DateTime p_date_limite)
	{
		titre       = SANS_TITRE;
		avencement  = 0;
		date_limite = p_date_limite;
	}
	
	@TLTest(status = STATUS.TESTED)
	public Tache(String p_titre, String p_categorie, DateTime p_date_limite)
	{
		titre       = p_titre;
		avencement  = 0;
		date_limite = p_date_limite;
	}
	
	@TLTest(status = STATUS.NOTEST)
	public final void setTitre(String p_nouveau_titre)
	{
		titre = p_nouveau_titre;
	}
		
	@TLTest(status = STATUS.NOTEST)
	public final String getTitre()
	{
		return titre;
	}
	
	@TLTest(status = STATUS.NOTEST)
	public final int getAvencement()
	{
		return avencement;
	}
	
	protected final void setAvencement(byte p_avencement)
	{
		avencement = p_avencement;
	}
	
	public abstract void incrementeAvencement();
	
	@TLTest(status = STATUS.NOTEST)
	public final DateTime getDateLimite()
	{
		return date_limite;
	}
	
	@TLTest(status = STATUS.NOTEST)
	public boolean valide()
	{
		//DateTimeFormat dtf = new DateTimeFormat();
		//TODO
		return true;
	}
	
	@Override
	@TLTest(status = STATUS.NOTEST)
	public boolean equals(Object o)
	{
		return false;
	}
	
	@Override
	@TLTest(status = STATUS.NOTEST)
	public int compareTo(Tache o)
	{
		return titre.compareTo(o.titre) + date_limite.compareTo(o.date_limite);
	}
	
	@Override
	@TLTest(status = STATUS.NOTEST)
	public String toString()
	{
		StringBuilder string_builder = new StringBuilder();
		string_builder.append("Titre       : " + titre                  + System.getProperty("line.separator"));
		string_builder.append("Avencement  : " + avencement             + System.getProperty("line.separator"));
		string_builder.append("Date limite : " + date_limite.toString() + System.getProperty("line.separator"));
		return string_builder.toString();
	}
	
	@TLTest(status = STATUS.TOTEST)
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
