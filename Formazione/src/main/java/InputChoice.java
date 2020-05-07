import java.util.*;

public class InputChoice {
	
	public InputChoice()
	{
		
	}
	
	public int getChoice()
	{
		Scanner input = new Scanner(System.in);
		System.out.println("Cosa vuoi fare?");
    	System.out.println("Scegli:");
    	System.out.println("1 - Output console");
    	System.out.println("2 - Salva i dati in un file csv");
    	System.out.println("3 - Salva i dati su database");
    	System.out.println("4 - Salva i dati in un file csv e su database");
		int choice = input.nextInt();
		return choice;
	}
	
}
