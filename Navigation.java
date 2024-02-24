public class Navigation extends Main {

	static Integer currentLocation;
	static Integer previousLocation;
// OPTIONS FOR NEXT LOCATION BASED ON CURRENT LOCATION
public void goLeft(Integer currentLocation) {
	
	if (currentLocation == 1) {
		previousLocation = currentLocation;

	}
	/*else if (currentLocation == "Plane Crash") {
		return option1 = "Go to River";
	}
	else if (currentLocation == "River") {
		return option1 = "Go to Beach";
	}
	else if (currentLocation == "Beach") {
		return option1 = "Go to River";
	}
	else if (currentLocation == "Jungle") {
		return option1 = "Go to Cave";
	}
return option1;*/ 
	


}
public String goRight(Integer currentLocation) {
    String option2 = " ";
    if (currentLocation == 1) {
        option2 = "Load Game";
    } else if (currentLocation == 2) {
        option2 = "Go to Jungle";
    } else if (currentLocation == 3) {
        option2 = " ";
    } else if (currentLocation == 4) {
        option2 = " ";
    } else if (currentLocation == 5) {
        option2 = "Go to Village";
    }
    return option2;
}
}


