import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.function.Consumer;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import java.util.ArrayList;
import java.util.List;

public class Player extends Main {
	
	private Location location;
	private int health;
	private List<Items> inventory; 
	
	private Ending Ending;
	private Ui Ui;
	
	
	
	
	public Player(Location initialLocation) {
		this.location = initialLocation;
				
//Setting default health to 10 max health 
		this.health = 10; 	
		
		this.inventory = new ArrayList<>();
	}
// chance to encounter enteraction that deplete health.
	public Location getLocation() {
		return location;
		
	}
	
	public void setLocation(Location location) {
		this.location = location;
		}
	
	public int getHealth() {
		return health;
		}
	
	public void setHealth(int health) {
		this.health = health;
		}
	
	public List<Items> getInventory() {
		return inventory;
		}

	//moving (add to button)
	public void move(Location newLocation) {
		this.location = newLocation;
		}
	
	public boolean isAlive() {
		return health > 0;
		}
	
	public void collectItem(Items item) {
		inventory.add(item);
//popup confirmation box
		}
	
		
	public void useItem(Items item) { 
		}
	
		
	
	public Player () {
		
		
		
	}
	public static void add(String item) {
		// TODO Auto-generated method stub
		
	}
}
