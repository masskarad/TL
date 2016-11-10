package model.tache.liste_tache;

import java.util.*;

import model.tache.Tache;

public abstract class ListeTache implements SortedSet<Tache>, Comparator<Tache>
{

    private SortedSet<Tache> liste_taches;

    public Set<Tache> getListe_taches()
    {
        return liste_taches;
    }

    public ListeTache()
    {
        liste_taches = new TreeSet<Tache>((Comparator)this);
    }

    public ListeTache(Tache[] p_liste_taches)
    {
        //liste_taches = Arrays.asList(p_liste_taches);
    }

    @Override
    public abstract int compare(Tache tache, Tache t1);

    @Override
    public Comparator<? super Tache> comparator()
    {
        return (Comparator) this;
    }

    @Override
    public SortedSet<Tache> subSet(Tache tache, Tache e1)
    {
        return liste_taches.subSet(tache, e1);
    }

    @Override
    public SortedSet<Tache> headSet(Tache tache)
    {
        return liste_taches.headSet(tache);
    }

    @Override
    public SortedSet<Tache> tailSet(Tache tache)
    {
        return liste_taches.tailSet(tache);
    }

    @Override
    public Tache first()
    {
        return liste_taches.first();
    }

    @Override
    public Tache last()
    {
        return liste_taches.last();
    }

    @Override
    public int size()
    {
        return liste_taches.size();
    }

    @Override
    public boolean isEmpty()
    {
        return liste_taches.isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return liste_taches.contains(o);
    }

    @Override
    public Iterator<Tache> iterator()
    {
        return liste_taches.iterator();
    }

    @Override
    public Object[] toArray()
    {
        return liste_taches.toArray();
    }

    @Override
    public <T> T[] toArray(T[] ts)
    {
        return liste_taches.toArray(ts);
    }

    @Override
    public boolean add(Tache tache)
    {
        return liste_taches.add(tache);
    }

    @Override
    public boolean remove(Object o)
    {
        return liste_taches.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> collection)
    {
        return liste_taches.containsAll(collection);
    }

    @Override
    public boolean addAll(Collection<? extends Tache> collection)
    {
        return liste_taches.addAll(collection);
    }

    @Override
    public boolean retainAll(Collection<?> p_collection)
    {
        return liste_taches.retainAll(p_collection);
    }

    @Override
    public boolean removeAll(Collection<?> p_collection)
    {
        return liste_taches.removeAll(p_collection);
    }

    @Override
    public void clear()
    {
        liste_taches.clear();
    }
    
    @Override
    public String toString()
    {
    	StringBuilder string_builder = new StringBuilder();
    	for(Tache tache : liste_taches)
    		string_builder.append(tache.toString() + System.getProperty("line.separator"));
    	return string_builder.toString();
    }
}
