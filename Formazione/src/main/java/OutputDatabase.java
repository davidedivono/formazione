import java.util.*;
import java.io.*;
import java.sql.*;
import nu.xom.*;

public class OutputDatabase implements Output {
	private XmlPersonParser parser;
	
	public OutputDatabase()
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
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		dbc.start();
		try 
		{
			Statement stmt = dbc.getConnection().createStatement();					 
			for (int q = 0; q < parser.parseXML(file).length; q++)
	        {
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				stmt.execute("INSERT INTO person (uniqueKey, name, surname, birth, tinsert) VALUES(" + "'" + parser.parseXML(file)[q].getKey() + "', '" + parser.parseXML(file)[q].getName() + "', '" + parser.parseXML(file)[q].getSurname() + "', '" + parser.parseXML(file)[q].getDate() + "', '" + timestamp + "')");
	        }
			System.out.println("Aggiunta al database avvenuta correttamente!");
			stmt.close();
			dbc.closeConnection();
        }
        catch (NullPointerException ex)
        {
            ex.printStackTrace();
        } 
		catch (SQLException e)
		{
			e.printStackTrace();
		}	
	}
	
}
