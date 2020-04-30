import java.io.*;
import nu.xom.*;

public class Main {
	
	public static void main (String[] args) throws ValidityException, ParsingException, IOException 
	{
		Composite composite = Composite.getInstance();
		OutputConsole outputconsole = new OutputConsole();
		OutputCsv outputcsv = new OutputCsv();
		OutputDatabase outputdb = new OutputDatabase();
		composite.add(outputconsole);
		composite.add(outputcsv);
		composite.add(outputdb);
		composite.run();
	}
	
}
