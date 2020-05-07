import java.util.*;
import java.io.*;
import nu.xom.*;

public class OutputConsole implements Output {
	private XmlPersonParser parser;
	
	public OutputConsole ()
	{
		parser = XmlPersonParser.getInstance();
	}

	@Override
	public void run(List<Person> personlist) throws ValidityException, ParsingException, IOException 
	{
		for (int i = 0; i < personlist.size(); i++)
        {
            System.out.println(personlist.get(i).toString());
        }		
	}
	
}
