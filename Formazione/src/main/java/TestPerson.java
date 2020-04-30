import org.junit.*;
import static org.junit.Assert.*;

public class TestPerson {
	private Person person;

	@Before
	public void before()
	{
		person = new Person("KKSSIOSDISOD979", "Mario", "Rossi", "1992/04/18");
	}

	@Test
	public void testKey() 
	{
		assertEquals("La chiave �: KKSSIOSDISOD979", "KKSSIOSDISOD979", person.getKey());
	}
	
	@Test
	public void testName()
	{
		assertEquals("Il nome �: Mario", "Mario", person.getName());
	}

	@Test
	public void testSurname() 
	{
		assertEquals("Il cognome �: Rossi", "Rossi", person.getSurname());
	}

	@Test
	public void testDate() 
	{
		assertEquals("La data di nascita �: 1992/04/18", "1992/04/18", person.getDate());
	}

}
