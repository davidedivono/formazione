import java.util.*;
import java.io.*;
import java.sql.*;
import nu.xom.*;

public class First {
	public static void main (String[] args) throws IOException, ParsingException{
		
		//acquisisco il file xml
        Scanner input = new Scanner(System.in);
        System.out.println("Inserisci il path del file XML");
        String path = input.nextLine();
		File file = new File(path);
		
		//lettura del file xml
		Builder builder = new Builder();
        Document doc = builder.build(file);
        Element root = doc.getRootElement();
        Elements people = root.getChildElements("Person");
		Person[] persone = new Person[people.size()];		
        for (int q = 0; q < people.size(); q++)
        {
            Element person = people.get(q);
            Element key = person.getFirstChildElement("uniqueKey");
            Element name = person.getFirstChildElement("name");
            Element surname = person.getFirstChildElement("surname");
            Element birth = person.getFirstChildElement("Birth");
            try 
            {
            	Person p = new Person(key.getValue(), name.getValue(), surname.getValue(), birth.getValue());
            	persone[q] = p;
            }
            catch (NullPointerException ex)
            {
                ex.printStackTrace();
            }
        }
        
        //menù di help sulle funzionalità offerte
    	System.out.println("Cosa vuoi fare?");
    	System.out.println("Scegli:");
    	System.out.println("0 - Output console");
    	System.out.println("1 - Salva i dati in un file csv");
    	System.out.println("2 - Salva i dati su database");
    	int scelta=input.nextInt();
    	switch(scelta)
    	{
    		case 0:
    			//stampo su console
    			for (int q = 0; q < persone.length; q++)
    	        {
    	            System.out.println(persone[q].printConsole());
    	        }
    			break;
    		case 1:
    			//creo il file csv di output
    			FileWriter csv = new FileWriter("output.csv");
    			csv.append("Chiave");
    	    	csv.append(",");
    			csv.append("Name");
    	    	csv.append(",");
    	    	csv.append("Surname");
    	    	csv.append(",");
    	    	csv.append("Birthday");
    	    	csv.append("\n");	    	
    			for (int q = 0; q < persone.length; q++)
    	        {
    				persone[q].printCsv(csv);
    	        }
    			break;
    		case 2:
    			//tabella su database
				try 
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
				} 
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				}
				Connection connection = null;
				try 
				{
					connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1/corso", "root", "");
					Statement stmt = connection.createStatement();					 
					for (int q = 0; q < persone.length; q++)
	    	        {
						Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    				stmt.execute("INSERT INTO person (uniqueKey, name, surname, birth, tinsert) VALUES(" + "'" + persone[q].getKey() + "', '" + persone[q].getName() + "', '" + persone[q].getSurname() + "', '" + persone[q].getDate() + "', '" + timestamp + "')");
	    	        }
					stmt.close();
					connection.close();
    	        }
    	        catch (NullPointerException ex)
    	        {
    	            ex.printStackTrace();
    	        } 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
    			break;
    		default:
    			System.out.println("ERRORE: Non hai inserito la scelta correttamente!");
    			break;
    	}  	
	}
}
