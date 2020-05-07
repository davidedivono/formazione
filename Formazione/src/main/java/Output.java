import java.util.*;
import java.io.*;
import nu.xom.*;

public interface Output {
	
	public void run(List<Person> personlist) throws ValidityException, ParsingException, IOException;

}
