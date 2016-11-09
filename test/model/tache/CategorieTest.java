package model.tache;

import static org.junit.Assert.*;

import org.junit.Test;

@RunWith(Parameterized.class)
public class CategorieTest
{
	private String operator1;
	private String operator2;
	private Categorie categorie;

	public CategorieTest(String operator1, String operator2) {
		this.operator1 = operator1;
		this.operator2 = operator2;
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
