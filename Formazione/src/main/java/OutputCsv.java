import java.util.*;
import java.io.*;
import nu.xom.*;

public class OutputCsv implements Output {
	private XmlPersonParser parser;
	
	public OutputCsv()
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
		FileWriter csv = new FileWriter("output.csv");
		csv.append("Chiave");
    	csv.append(",");
		csv.append("Name");
    	csv.append(",");
    	csv.append("Surname");
    	csv.append(",");
    	csv.append("Birthday");
    	csv.append("\n");	    	
		for (int q = 0; q < parser.parseXML(file).length; q++)
        {
			parser.parseXML(file)[q].printPersonOnCsv(csv);
        }
		System.out.println("File csv creato correttamente!");
	}
	
}
