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
	public void run() throws ValidityException, ParsingException, IOException 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Inserisci il path del file: ");
		String path = input.nextLine();
		File file = new File(path);
		for (int q = 0; q < parser.parseXML(file).length; q++)
        {
            System.out.println(parser.parseXML(file)[q].printConsole());
        }		
	}
	
}
