package model.tache;

import java.util.HashMap;

import org.joda.time.DateTime;

public final class TacheAuLong extends Tache
{
	private DateTime date_debut;
	HashMap<Integer, Long> etapes;
	private long duree;
	
	public TacheAuLong()
	{
		super();
	}
	
	public Tache(String p_titre)
	{
		super(p_titre);
	}
	
	public Tache(DateTime p_date_limite)
	{
		super(p_date_limite);
	}
	
	public Tache(String p_titre, String p_categorie, DateTime p_date_limite)
	{
		super(p_titre, p_categorie, p_date_limite);
	 }
	
	public TacheAuLong(DateTime p_date_limite, DateTime p_date_debut) throws TacheException
	{
		super(p_date_limite);
		
		if(p_date_debut.isAfter(getDate_limite()))
			throw new TacheException("Date debut > Date limite");
		
		date_debut = p_date_debut;
		etapes     = new HashMap<Integer, Long>();
	}
	
	private void genererEtapes()
	{
		etapes.put(0, duree);
		etapes.put(25, duree / 4);
		etapes.put(50, duree / 4);
		etapes.put(75, duree / 4);
		etapes.put(100, 0l);
	}
		
	@Override
	public boolean estEnRetard()
	{
		return true;
	}
}
