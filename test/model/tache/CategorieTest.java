package model.tache;

import static org.junit.Assert.*;

import org.junit.Test;

@RunWith(Parameterized.class)
public class CategorieTest
{
	private String operator1;
	private String operator2;
	private Categorie categorie;

	public CategorieTest(String p_operator1, String p_operator2)
	{
		operator1 = p_operator1;
		operator2 = p_operator2;
	}

	@Parameters
	public static Collection<Object[]> setParameters()
	{
		Collection<Object[]> params = new ArrayList<>();
		params.add(new Object[]{MIAOU, MIAOU});
		params.add(new Object[]{MIAOU, MIAOU});

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
		categorie
	}
	
	@Test
	public void testAjouterCategorieExistante()
	{
		
	}
	
	@Test
	public void testAjouterMajuscule()
	{
		
	}
	
	@Test
	public void testSupprimerExistant()
	{
		
	}

	@Test
	public void testSupprimerNonExistant()
	{
		
	}
	
	@Test
	public void testModifierExistant()
	{
		
	}
	

	@Test
	public void testModifierNonExistant()
	{
		
	}
}
