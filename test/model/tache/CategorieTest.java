package model.tache;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import model.tache.Categorie;

@RunWith(Parameterized.class)
public class CategorieTest
{
	private String categorie1;
	private String categorie2;
	private String expected1;
	private String expected2;
	private Categorie categorie;

	public CategorieTest(String p_categorie1, String p_categorie2, String p_expected1, String p_expected2)
	{
		categorie1 = p_categorie1;
		categorie2 = p_categorie2;
		expected1 = p_expected1;
		expected2 = p_expected2;
	}

	@Parameters
	public static Collection<Object[]> setParameters()
	{
		Collection<Object[]> params = new ArrayList<>();
		params.add(new Object[]{"LECTURE", "REVISIONS", "LECTURE", "REVISIONS"});
		params.add(new Object[]{"LECTURE", "revisions", "LECtURE", "REVISIONS"});
		params.add(new Object[]{"lecture", "REVISIONS", "LECTURE", "REVISIONS"});
		params.add(new Object[]{"lecture", "revisions", "LECTURE", "REVISIONS"});

		return params;
	}

	@Before
	public void createCategorie()
	{
		categorie = new Categorie();
	}


	@Test
	public void testAjouterNouvelleCategorie()
	{
		Categorie.addCategorieDisponible(categorie1);
		Assert.assertTrue(Categorie.containsCategories_disponibles(expected1));
		Assert.assertFalse(Categorie.containsCategories_disponibles(expected2));
	}
	
	@Test
	public void testSupprimerExistant()
	{
		Categorie.addCategorieDisponible(categorie1);
		Categorie.removeCategorieDisponible(expected1);
		Assert.assertFalse(Categorie.containsCategories_disponibles(expected1));
	}

	@Test
	public void testSupprimerNonExistant()
	{
		Categorie.addCategorieDisponible(categorie1);
		Categorie.removeCategorieDisponible(expected1);
		Assert.assertFalse(Categorie.removeCategorieDisponible(expected2));
		Assert.assertFalse(Categorie.containsCategories_disponibles(expected2));
	}
	
	@Test
	public void testModifierExistant()
	{
		System.out.println();
		System.out.println();
	}
	

	@Test
	public void testModifierNonExistant()
	{
		
	}
}
