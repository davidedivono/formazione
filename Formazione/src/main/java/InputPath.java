import java.util.*;

public class InputPath {
	
	public InputPath()
	{
		
	}
	
	public String getPath()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Inserisci il path del file: ");
		String path = input.nextLine();
		return path;
	}
	
}
