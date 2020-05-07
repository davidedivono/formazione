import java.io.*;

public class Person {
	private String key;
	private String name;
	private String surname;
	private String date;

	public Person(String k, String n, String c, String d)
	{
		key = k;
		name = n;
		surname = c;
		date = d;
	}
	
	public void setKey(String k)
	{
		key = k;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setSurname(String c)
	{
		surname = c;
	}
	
	public void setDate(String d)
	{
		date = d;
	}
	
	public String getKey()
	{
		return key;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getSurname()
	{
		return surname;
	}
	
	public String getDate()
	{
		return date;
	}
	
	@Override
	public String toString()
	{
		return "Chiave: " + key + "  Name: " + name + "  surname: " + surname + "  birthday: " + date;
	}
	
	public void toStringOnCsv(FileWriter csv) throws IOException
	{
		csv.append(key);
       	csv.append(",");
		csv.append(name);
       	csv.append(",");
       	csv.append (surname);
      	csv.append(",");
      	csv.append(date);
    	csv.append("\n");
        csv.flush();
	}
	
}
