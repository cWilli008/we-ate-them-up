import java.util.ArrayList;

public class Location extends Main {
	

	
		//Instance variables for the properties of the location
		    private String name;
		    private String description;
			private boolean hasEvent;
						
			private Location[] exits;

		//Initializing location with name, description, and event status
		    public Location() {
		        this.name = name;
		        this.description = description;
			    this.hasEvent =hasEvent;
			exits = new Location[2]; //there should be 2 exits within a location  

			ArrayList<String> Locations = new ArrayList<String>();
			
			Locations.add("Menu");//0
			Locations.add("Plane Crash");//1
			Locations.add("River");//2
			Locations.add("Beach");//3
			Locations.add("Jungle");//4
			Locations.add("Cave");//5
			Locations.add("Village");//6
			
			
						
			
			
			
		    }
	        //Getter methods for retrieving location information
		    public String getName() {
		        return name;
		    }

		    public String getDescription() {
		        return description;
		    }

		    public boolean hasEvent() {
		        return hasEvent;
		    }

	        //Setter method to exit location at a specific index
			public void setExit(int index, Location exitLocation) {
				exits[index] = exitLocation;
			}

	        //Getter method to exit location at a specific index
			public Location getExit(int index) {
				return exits[index];
				
			}

	       //Method to simulate entering a location
			public void enterLocation() {
			 System.out.println("You have entered the " + name + ".");
		        System.out.println(description);

	       //Checks of location has an event			
		        if (hasEvent) {
		            handleEvent();
		        }
		    }

	       //Method to handle specific events based on the location
		    private void handleEvent() {
		        // Implement event logic for the location
		        System.out.println(" LOOK, something appears to be happening at the " + name + ".");
		        // HARDCODE BEFORE player enters location 

	       //Switch statements to handle events based on the location's name 	    
		        switch (name) {

					//plane crash location
			case "Plane Crash Site":
		            break;
							
					//Jungle Location	
		        case "Jungle":
					break;


					//Cave SubLocation
				case "Cave":
					break;

					//Village Location
				case "Village":
					break; 

					//River Location		
		        case "River":
		            break;

					//Beach Location		        
		        case "Beach":
		        	
		        default:
					break;
					}
		    }
			public void location() {
				// TODO Auto-generated method stub
				
			}
		}
