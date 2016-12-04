package model.tache;

import java.util.HashMap;

import org.joda.time.DateTime;

import annotation.TLTest;
import annotation.TLTest.STATUS_TEST;

@SuppressWarnings("serial")
public final class TacheAuLong extends Tache
{
	private long           duree;
	private DateTime       date_debut;
	HashMap<Integer, Long> etapes;
	
	public TacheAuLong()
	{
		super();
		
		date_debut = DateTime.now();
		etapes     = new HashMap<Integer, Long>();
		
		duree      = getDateLimite().getMillis() - date_debut.getMillis();
		
		genererEtapes();
	}
	
	public TacheAuLong(String p_titre)
	{
		super(p_titre);
		
		date_debut = DateTime.now();
		etapes     = new HashMap<Integer, Long>();
		
		duree      = getDateLimite().getMillis() - date_debut.getMillis();
		
		genererEtapes();
	}
	
	public TacheAuLong(DateTime p_date_limite)
	{
		super(p_date_limite);
		
		date_debut = DateTime.now();
		etapes     = new HashMap<Integer, Long>();
		
		duree      = getDateLimite().getMillis() - date_debut.getMillis();
		
		genererEtapes();
	}
	
	public TacheAuLong(String p_titre, String p_categorie, DateTime p_date_limite) throws Exception
	{
		super(p_titre, p_categorie, p_date_limite);
		
		date_debut = DateTime.now();
		etapes     = new HashMap<Integer, Long>();
		
		duree      = getDateLimite().getMillis() - date_debut.getMillis();
		
		genererEtapes();
	 }
	
	public TacheAuLong(DateTime p_date_debut, DateTime p_date_limite) throws TacheException
	{
		super(p_date_limite);
		
		if(p_date_debut.isAfter(getDateLimite()))
			throw new TacheException("Date debut > Date limite");
		
		date_debut = p_date_debut;
		etapes     = new HashMap<Integer, Long>();
		
		duree      = getDateLimite().getMillis() - date_debut.getMillis();
		
		genererEtapes();
	}
	
	public TacheAuLong(String p_titre, String p_categorie, DateTime p_date_debut, DateTime p_date_limite) throws Exception
	{
		super(p_titre, p_categorie, p_date_limite);
		
		if(p_date_debut.isAfter(getDateLimite()))
			throw new TacheException("Date debut > Date limite");
		
		date_debut = p_date_debut;
		etapes     = new HashMap<Integer, Long>();
		
		duree      = getDateLimite().getMillis() - date_debut.getMillis();
		
		genererEtapes();
	}
	
	/**
	 * 
	 */
	private void genererEtapes()
	{
		etapes.put(0, duree);
		etapes.put(25, (long) (duree * 0.25));
		etapes.put(50, (long) (duree * 0.50));
		etapes.put(75, (long) (duree * 0.75));
		etapes.put(100, 0l);
	}
		
	@TLTest(status = STATUS_TEST.TOTEST)
	public boolean estEnRetard()
	{
		return getDateLimite().getMillis() < etapes.get(getAvencement());
	}
	
	@Override
	public void incrementeAvencement()
	{
		if(getAvencement() == 100)
			return;
		else
			setAvencement((byte) (getAvencement() + 25));
	}
	
	public static void main(String [] Args)
	{
		TacheAuLong tache_au_long = new TacheAuLong();
		System.out.println(tache_au_long.estEnRetard());
	}
}
