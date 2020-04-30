import java.io.*;
import nu.xom.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestXml {
	File file = new File("C:/RGI/Projects/Corso/personlist.xml");
	private XmlPersonParser parser;
	
	@Before
	public void before() throws ValidityException, ParsingException, IOException
	{
		parser = XmlPersonParser.getInstance();
	}

	@Test
	public void testParserKey() throws ValidityException, ParsingException, IOException
	{
		String key = parser.parseXML(file)[0].getKey();
		assertEquals("La chiave è: KKSSIOSDISOD999", "KKSSIOSDISOD999", key);
	}
	
	@Test
	public void testParserName() throws ValidityException, ParsingException, IOException
	{
		String name = parser.parseXML(file)[0].getName();
		assertEquals("Il nome è: Pippo", "Pippo", name);
	}
	
	@Test
	public void testParserSurname() throws ValidityException, ParsingException, IOException
	{
		String surname = parser.parseXML(file)[0].getSurname();
		assertEquals("Il cognome è: Carlos", "Carlos", surname);
	}
	
	@Test
	public void testParserDate() throws ValidityException, ParsingException, IOException
	{
		String date = parser.parseXML(file)[0].getDate();
		assertEquals("La data di nascita è: 1998/03/25", "1998/03/25", date);
	}
	
	@Test
	public void testKeyLenght() throws ValidityException, ParsingException, IOException
	{
		String key = parser.parseXML(file)[0].getKey();
		assertTrue((key.length()<=15) && (key.length()>=1));
	}
	
	@Test
	public void testNameLenght() throws ValidityException, ParsingException, IOException
	{
		String name = parser.parseXML(file)[0].getName();
		assertTrue((name.length()<=50) && (name.length()>=1));
	}
	
	@Test
	public void testSurnameLenght() throws ValidityException, ParsingException, IOException
	{
		String surname = parser.parseXML(file)[0].getSurname();
		assertTrue((surname.length()<=50) && (surname.length()>=1));
	}
		
}
