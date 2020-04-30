import java.util.*;
import java.io.*;
import java.lang.*;
import nu.xom.*;
import org.junit.*;
import static org.junit.Assert.*;

public class TestCsv {
	File file = new File("C:/RGI/Projects/socgen/formazione/output.csv");
	String array[];
	List<String> list = new ArrayList<>();
	
	@Before
	public void before()
	{
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(file));
	        String line = "";
	        while((line = reader.readLine()) != null)
	        {
	            array = line.split(",");
	            for(int i = 0; i<array.length; i++)
	            {
	            	list.add(array[i]);
	            }
	            
	        }
	    } 
		catch (FileNotFoundException e) 
		{
            e.printStackTrace();
        } 
		catch (IOException e) 
		{
            e.printStackTrace();
        }
	}

	@Test
	public void testKeyCsv()
	{
		assertTrue(list.contains("KKSSIOSDISOD999"));
	}
	
	@Test
	public void testNameCsv()
	{
		assertTrue(list.contains("Pippo"));
	}
	
	@Test
	public void testSurnameCsv()
	{
		assertTrue(list.contains("Carlos"));
	}
	
	@Test
	public void testDateCsv()
	{
		assertTrue(list.contains("1998/03/25"));
	}
	
}