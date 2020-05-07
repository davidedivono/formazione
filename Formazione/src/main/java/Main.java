import java.util.*;
import java.io.*;
import nu.xom.*;

public class Main {
	
	public static void main (String[] args) throws ValidityException, ParsingException, IOException 
	{
		InputChoice inputchoice = new InputChoice();
		int choice = inputchoice.getChoice();
		InputPath inputpath = new InputPath();
		String path = inputpath.getPath();
		File file = new File(path);
		XmlPersonParser xmlpersonparser = new XmlPersonParser();
		List<Person> personlist = new ArrayList<>();
		personlist = xmlpersonparser.parseXML(file);
		switch(choice)
    	{
    		case 1:
    			OutputConsole outputconsole = new OutputConsole();
    			outputconsole.run(personlist);
    			break;
    		case 2:
    			OutputCsv outputcsv = new OutputCsv();
    			outputcsv.run(personlist);
    			break;
    		case 3:
    			OutputDatabase outputdb = new OutputDatabase();
    			outputdb.run(personlist);
    			break;
    		case 4:
    			Decorator decorator = Decorator.getInstance();
    			decorator.run(personlist);
    			break;
    		default:
    			System.out.println("ERRORE: Non hai inserito la scelta correttamente!");
        		break;
    	}
	}
	
}
