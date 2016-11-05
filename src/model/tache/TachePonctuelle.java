package model.tache;

import org.joda.time.DateTime;

public final class TachePonctuelle extends Tache
{

	public TachePonctuelle(DateTime p_date_limite)
	{
		super(p_date_limite);
	}
	
	public boolean estEnRetard()
	{
		return DateTime.now().equals(getDate_limite().plus(1));
	}
}
