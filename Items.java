import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class Items extends Main {
	// TODO Auto-generated method stub
		//declare items 
	static List<String> itemsList = new ArrayList<>();
	
	private int sticksCollected;
	
	private boolean hasSeeds;
	private boolean hasGardenTools;
	
	private boolean hasBucket;
	
		
		public static void setItems() {
					
	itemsList.add("Bucket");//0
	itemsList.add("Flair Gun");//1
	itemsList.add("Fruit");//2
	itemsList.add("Garden Tools");//3
	itemsList.add("Rope");//4
	itemsList.add("Stick1");//5
	itemsList.add("Stick2");//6
	itemsList.add("Stick3");//7
	itemsList.add("Stick4");//8
	itemsList.add("Seeds");//9
	itemsList.add("Wires & Metal");//10
	itemsList.add("Boat");//11
	itemsList.add("Bucket of Water");//12
	itemsList.add("Lost Villager");//13
			
	// Choose where sticks spawn
	// Set to store unique random integers
    Set<Integer> generatedNumbers = new HashSet<>();

    // Generate and store unique random integers
    int min = 1;
    int max = 6;
    int numberOfRandomNumbers = 5; // Specify the number of unique random numbers needed

		//Random variable 
		    Random random = new Random();


    while (generatedNumbers.size() < numberOfRandomNumbers) {
        int randomNumber = random.nextInt(max - min + 1) + min;
        generatedNumbers.add(randomNumber);
        
    }
    System.out.println(generatedNumbers);
	//int stick1Spawn = generatedNumbers;
	//int stick2Spawn = generatedNumbers.get(1);
	//int stick3Spawn = generatedNumbers.get(2);
	//int stick4Spawn = generatedNumbers.get(3);
	  //int ropeSpawn = generatedNumbers.get(4);
   
    }
	
	
	
	
}
