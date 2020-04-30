import java.io.*;

public class Person {
	private String chiave;
	private String nome;
	private String cognome;
	private String data;

	public Person(String k, String n, String c, String d)
	{
		chiave = k;
		nome = n;
		cognome = c;
		data = d;
	}
	
	public void setKey(String k)
	{
		chiave = k;
	}
	
	public void setName(String n)
	{
		nome = n;
	}
	
	public void setSurname(String c)
	{
		cognome = c;
	}
	
	public void setDate(String d)
	{
		data = d;
	}
	
	public String getKey()
	{
		return chiave;
	}
	
	public String getName()
	{
		return nome;
	}
	
	public String getSurname()
	{
		return cognome;
	}
	
	public String getDate()
	{
		return data;
	}
	
	public String printConsole()
	{
		return "Chiave: " + chiave + "  Name: " + nome + "  surname: " + cognome + "  birthday: " + data;
	}
	
	public void printPersonOnCsv(FileWriter csv) throws IOException
	{
		csv.append(chiave);
       	csv.append(",");
		csv.append(nome);
       	csv.append(",");
       	csv.append (cognome);
      	csv.append(",");
      	csv.append(data);
    	csv.append("\n");
        csv.flush();
	}
	
}
