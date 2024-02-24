import java.util.ArrayList;


public class Inventory extends Main {
	boolean savedVillager = false;
	
	static ArrayList<String>  playerInv = new ArrayList<String>();
	
	public static void printInventory() {
        System.out.println("Inventory:" +  playerInv);
	}
	
	
	public void addItem(String item) {
	  playerInv.add(item);
	
	
	

	}
	
	public void useItem(String item) {
		// CREATE BOAT
		if (item == "Stick1" || item == "Stick2" || item == "Stick3" || item == "Stick4" || item == "Rope") {
			if (playerInv.contains(Items.itemsList.get(5)) &&  playerInv.contains(Items.itemsList.get(6)) &&  playerInv.contains(Items.itemsList.get(7)) &&  playerInv.contains(Items.itemsList.get(8)) && playerInv.contains(Items.itemsList.get(4))) {
				 playerInv.remove("Stick1");
				 playerInv.remove("Stick2");
				 playerInv.remove("Stick3");
				 playerInv.remove("Stick4");
				 playerInv.remove("Rope");
				 playerInv.add("Boat");
				
			}
		}
		
		
		// BOAT ENDING
		if (item == "Boat") {
			if (Navigation.currentLocation == "Beach") {
				if(playerInv.contains(Items.itemsList.get(11))) {
					Ending.BeachEnding();
				}
			}
			
		// COLLECT WATER
		if (item == "Bucket") {
			if (Navigation.currentLocation == "River") {
				if (playerInv.contains(Items.itemsList.get(0))) {
					playerInv.remove("Bucket");
					playerInv.add("Bucket of Water");
				
									}
			}
		}
		
		// GIVE VILLAGER TO VILLAGE
		if (item == "Lost Villager") {
			if (Navigation.currentLocation == "Village") {
				if (playerInv.contains(Items.itemsList.get(13))) {
					playerInv.remove("Lost Villager");
					playerInv.add("Seeds");
					playerInv.add("Garden Tools");
					savedVillager = true;
					
				}
			}
		}
		
		// USE TOOLS AND SEEDS TO GROW FRUIT
		if (item == "Seeds" || item == "Garden Tools") {
			if (Navigation.currentLocation == "Village") {
				if (playerInv.contains(Items.itemsList.get(3)) && playerInv.contains(Items.itemsList.get(9)) && playerInv.contains(Items.itemsList.get(12))) {
					playerInv.remove("Bucket of Water");
					playerInv.remove("Seeds");
					playerInv.add("Bucket");
					playerInv.add("Fruit");
					
				}
			}
		}
		
		// PLANE ENDING
		if (item == "Wires & Metal" || item == "Flare Gun") {
			if (Navigation.currentLocation == "Plane Crash") {
				if (playerInv.contains(Items.itemsList.get(1)) && playerInv.contains(Items.itemsList.get(10))) {
					Ending.CrashSiteEnding();
					
					
				}
			}
		}
		
		if (item == "Fruit" || savedVillager == true) {
			if (Navigation.currentLocation == "Plane Crash") {
				if (playerInv.contains(Items.itemsList.get(2))) {
					Ending.VillageEnding();
					
					
				}
			}	
		}
	}

}
	

}
