package model.tache;

import org.joda.time.DateTime;

public final class TachePonctuelle extends Tache
{

	public Tache()
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
	
	public boolean estEnRetard()
	{
		return DateTime.now().equals(getDate_limite().plus(1));
	}
}
