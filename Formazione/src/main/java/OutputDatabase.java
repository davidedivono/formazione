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
	public void run(List<Person> personlist) throws ValidityException, ParsingException, IOException 
	{
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		dbc.start();
		try 
		{
			Statement stmt = dbc.getConnection().createStatement();					 
			for (int i = 0; i < personlist.size(); i++)
	        {
				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
				stmt.execute("INSERT INTO person (uniqueKey, name, surname, birth, tinsert) VALUES(" + "'" + personlist.get(i).getKey() + "', '" + personlist.get(i).getName() + "', '" + personlist.get(i).getSurname() + "', '" + personlist.get(i).getDate() + "', '" + timestamp + "')");
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
