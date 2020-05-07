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
	public void run(List<Person> personlist) throws ValidityException, ParsingException, IOException 
	{
		FileWriter csv = new FileWriter("output.csv");
		csv.append("Key");
    	csv.append(",");
		csv.append("Name");
    	csv.append(",");
    	csv.append("Surname");
    	csv.append(",");
    	csv.append("Birthday");
    	csv.append("\n");	    	
		for (int i = 0; i < personlist.size(); i++)
        {
			personlist.get(i).toStringOnCsv(csv);;
        }
		System.out.println("File csv creato correttamente!");
	}
	
}
