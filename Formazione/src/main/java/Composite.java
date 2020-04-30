import java.util.*;
import java.io.*;
import nu.xom.*;

public class Composite implements Output {
	private static Composite instance = null;
	private List<Output> output = new ArrayList<Output>(); 
	
	public Composite()
	{
		
	}
	
	public static Composite getInstance()
	{
	    if(instance == null)
	    {
	    	instance = new Composite();
	    }      
	    return instance;
	}
	
	@Override
	public void run() throws ValidityException, ParsingException, IOException 
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Cosa vuoi fare?");
    	System.out.println("Scegli:");
    	System.out.println("1 - Output console");
    	System.out.println("2 - Salva i dati in un file csv");
    	System.out.println("3 - Salva i dati su database");
    	System.out.println("4 - Salva i dati in un file csv e su database");
    	int scelta = input.nextInt();
    	switch(scelta)
    	{
    		case 1:
    			for(int i = 0; i<output.size(); i++)
    			{
    				if(output.get(i).getClass() == OutputConsole.class)
    				{
    					output.get(i).run();
    				}
    			}
    			break;
    		case 2:
    			for(int i = 0; i<output.size(); i++)
    			{
    				if(output.get(i).getClass() == OutputCsv.class)
    				{
    					output.get(i).run();
    				}
    			}
    			break;
    		case 3:
    			for(int i = 0; i<output.size(); i++)
    			{
    				if(output.get(i).getClass() == OutputDatabase.class)
    				{
    					output.get(i).run();
    				}
    			}
    			break;
    		case 4:
    			Decorator decorator = new Decorator();
    			decorator.run();
    			break;
    		default:
    			System.out.println("ERRORE: Non hai inserito la scelta correttamente!");
        		break;
    	}
	}
	
	public void add(Output o)
	{
		output.add(o);
	}

}
