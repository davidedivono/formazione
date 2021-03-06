import java.util.*;
import java.io.*;
import nu.xom.*;

public class XmlPersonParser extends Parser {
	private static XmlPersonParser instance = null;

	public XmlPersonParser()
	{
		
	}
	
	public static XmlPersonParser getInstance()
	{
	    if(instance == null)
	    {
	    	instance = new XmlPersonParser();
	    }      
	    return instance;
	}
	
	public List<Person> parseXML(File file) throws ValidityException, ParsingException, IOException 
	{
		Builder builder = new Builder();
        Document doc = builder.build(file);
        Element root = doc.getRootElement();
        Elements people = root.getChildElements("Person");
        List<Person> list = new ArrayList<>();
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
            	list.add(p);
            }
            catch (NullPointerException ex)
            {
                ex.printStackTrace();
            }
        }
		return list;	
	}
	
}
