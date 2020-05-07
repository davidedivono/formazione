import java.util.*;
import java.io.*;
import nu.xom.*;

public class Decorator implements Output {
	private static Decorator instance = null;
	
	public Decorator()
	{
		
	}
	
	public static Decorator getInstance()
	{
	    if(instance == null)
	    {
	    	instance = new Decorator();
	    }      
	    return instance;
	}
	
	@Override
	public void run(List<Person> personlist) throws ValidityException, ParsingException, IOException 
	{
		OutputCsv outputcsv = new OutputCsv();
		OutputDatabase outputdb = new OutputDatabase();
		outputcsv.run(personlist);
		outputdb.run(personlist);
	}

}
