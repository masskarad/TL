package model.tache;

import static org.junit.Assert.*;

import org.junit.Test;

@RunWith(Parameterized.class)
public class CategorieTest
{
	private int operator1;
	private int operator2;
	private int expectedSum;
	private int expectedSub;

	public CategorieTest(int operator1, int operator2, int expectedSum, int expectedSub) {
		this.operator1 = operator1;
		this.operator2 = operator2;
	}

	@Parameters
	public static Collection<Object[]> setParameters()
	{
		Collection<Object[]> params = new ArrayList<>();
		params.add(new Object[]{2, 1, 3, 1});
		params.add(new Object[]{5, 2, 7, 3});

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
