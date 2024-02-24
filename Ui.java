import javax.swing.*;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.function.Consumer;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;


public class Ui extends Main {
	
	private static final ActionListener actionListener = null;
	public Player player = new Player();
	Navigation Navigation = new Navigation();
	
	private static JPanel cardPanel;
    private static CardLayout cardLayout;
    private static JTextArea textarea; 
    static ArrayList<String> images = new ArrayList<String>(7); // CREATES AN ARRAY OF THE LOCATION IMAGES SO THEY CAN BE INDEXED
    public static int currentImageIndex = 0;
    public String currentLocation = Navigation.currentLocation;
    public String previousLocation;
    
    public void actionPerformedLeft(JButton button, JButton button2, Consumer<ActionEvent> actionHandler) {
    	if (currentLocation == "Menu") {
    		previousLocation = currentLocation;
    		currentLocation = "Plane";
    		button.setText("Go to River");
    		button2.setText("Go to Jungle");

    	}
    	else if (currentLocation == "Plane Crash") {
    		previousLocation = currentLocation;
    		currentLocation = "River";
    		button.setText("Go to Beach");
    		button2.setText(" ");
    	}
    	else if (currentLocation == "River") {
    		previousLocation = currentLocation;
    		currentLocation = "Beach";
    		button.setText("Swim in Ocean");
    		button2.setText(" ");
    	}
    	else if (currentLocation == "Beach") {
    		previousLocation = currentLocation;
    		button.setText(" ");
    		button2.setText(" ");
    	}
    	else if (currentLocation == "Jungle") {
    		previousLocation = currentLocation;
    		currentLocation = "Cave";
    		button.setText(" ");
    		button2.setText(" ");

    	}


    }

    public void actionPerformedRight(JButton button2, JButton button, Consumer<ActionEvent> actionHandler) {
    	if (currentLocation == "Menu") {
    		button.setText("Start Game");
    		button2.setText(" ");
    	}
    	else if (currentLocation == "Plane Crash") {
    		previousLocation = currentLocation;
    		currentLocation = "Jungle";
    		button.setText("Go to Cave");
    		button2.setText("Go to Village");
    	}
    	else if (currentLocation == "Jungle") {
    		previousLocation = currentLocation;
    		currentLocation = "Village";
    		button.setText(" ");
    		button2.setText(" ");
    	}


    }

    public void actionPerformedBack(JButton button, JButton button2, Consumer<ActionEvent> actionHandler) {
    	currentLocation = previousLocation;
    	if (currentLocation == "Menu") {
    		button.setText("Start Game");
    		button2.setText(" ");
    	}
    	else if (currentLocation == "Plane Crash") {
    		button.setText("Go to River");
    		button2.setText("Go to Jungle");
    	}
    	else if (currentLocation == "River") {
    		button.setText("Go to Beach");
    		button2.setText(" ");
    	}
    	else if (currentLocation == "Beach") {
    		button.setText(" ");
    		button2.setText(" ");
    	}
    	else if (currentLocation == "Jungle") {
    		button.setText("Go to Cave");
    		button2.setText("Go to Village");
    	}
    	else if (currentLocation == "Cave") {
    		button.setText(" ");
    		button2.setText(" ");
    	}
    	else if (currentLocation == "Village") {
    		button.setText(" ");
    		button2.setText(" ");
    	}
    }
    
    // LOCATION IMAGE FILES
    static String menuImg = "resources/WelcomeScreen.jpg";
    static String planeCrashImg = "resources/PlaneCrashScene.jpg";
	static String jungleImg = "resources/JungleScene.jpg";
	static String villageImg = "resources/Village.jpg";
	static String caveImg = "resources/Cave.jpg"; 
	static String riverImg = "resources/River.jpg";
	static String beachImg = "resources/Beach.jpg";
		
	static String currentLocImg = menuImg;  
		{
    	images.add(menuImg);
    	images.add(planeCrashImg);
    	images.add(jungleImg);
    	images.add(villageImg);
    	images.add(caveImg);
    	images.add(riverImg);
    	images.add(beachImg);
    	System.out.println(images);
    	}
		
    	 static ImageIcon currentScreen = new ImageIcon(currentLocImg);
    	 static JLabel screenLabel = new JLabel(currentScreen);
    	//static String currentLocImg = images.get(Navigation.locNumber);
    	     	 
    public Ui() {
    	 cardPanel = new JPanel();
         cardLayout = new CardLayout();
         cardPanel.setLayout(cardLayout);
                          
             screenLabel = new JLabel(new ImageIcon());
             cardPanel.add(screenLabel);
         
         cardPanel.add(screenLabel);
     }
        
    
    
    
    public void updateImage() {
    	currentImageIndex = (currentImageIndex + 1) % images.size(); // Cycle through the images
		String imagePath = images.get(currentImageIndex);
        
		try {
             File file = new File(imagePath);
             
             if(file.exists()) {
            	 Image image = ImageIO.read(file);
            	 ImageIcon newScreen = new ImageIcon(image);
                 screenLabel.setIcon(newScreen);
                 
             } else {
            	 System.err.println("Resource not found: " + images.get(currentImageIndex));
            	 } 
		}
             catch (IOException e) {
        		 e.printStackTrace();
        	 }
		}
              
     public static JPanel getCardPanel() {
         return cardPanel;
     }
     
     JTextArea createText1 (String text) {
     	textarea = new JTextArea (10, 10);
     	textarea.setText(text);
     	textarea.setEditable(false);
     	textarea.setLineWrap(true);
     	textarea.setWrapStyleWord(true);
     	return textarea;
     }

     public void showNextCard() {
         cardLayout.next(cardPanel);
    	 updateImage();
    	    
     	// CHANGES SET LOCATION SO SYSTEM KNOWS MORE THAN SIMPLY LEFT OR RIGHT
    	 switch (currentImageIndex) {
         case 0:
             currentLocation = "Menu";
             break;
         case 1:
             currentLocation = "Plane Crash Site";
             break;
         case 2:
             currentLocation = "Jungle";
             break;
         case 3:
             currentLocation = "Village";
             break;
         case 4:
             currentLocation = "Cave";
             break;
         case 5:
             currentLocation = "River";
             break;
         case 6:
             currentLocation = "Beach";
             break;
         default:
             currentLocation = "Unknown";
             break;
     }
    	 //currentLocation = currentLocation;
    	     		
 	}
     static JTextArea createText (String text) {
      	textarea = new JTextArea (10, 10);
      	textarea.setText(text);
      	textarea.setEditable(false);
      	textarea.setLineWrap(true);
      	textarea.setWrapStyleWord(true);
      	return textarea;
     }
     
     //Image & method to navigate location
	 public void goToPlaneCrashSite() {
		 currentImageIndex = 1;
		 showNextCard();
		     	 }
	 public void goToJungle() {
		 currentImageIndex = 2;
		 showNextCard();
		     	 }
	 public void goToVillage() {
		 currentImageIndex = 3;
		 showNextCard();
		     	 }
	 public void goToCave() {
		 currentImageIndex = 4;
		 showNextCard();
		     	 }
	 public void goToRiver() {
		 currentImageIndex = 5;
		 showNextCard();
		     	 }
	 public void goToBeach() {
		 currentImageIndex = 6;
		 showNextCard();
	 }
     
     public static void showPreviousCard() {
         cardLayout.previous(cardPanel);
     }

     //public static 
     public JButton addButton(String labelb, Consumer<ActionEvent> actionHandler) {
     	JButton button = new JButton(labelb);
     	button.addActionListener(new ActionListener() {
     		
     		@Override
     		public void actionPerformed(ActionEvent e) {
     			actionHandler.accept(e);
     			}
     	});
     	 		
     		return button;
     }

     	     
        //in order to change the stuff happening as per location
	    public void changeButton (JButton button, String label, String tooltip, ActionListener actionListener) {
	    	button.setText(label);
	    	button.setToolTipText(tooltip);
	    	button.removeActionListener(button.getActionListeners()[0]);
	    	button.addActionListener(actionListener);
	    }
	    
	    //THIS IS FOR REGULAR PANELS, NOT GAME PANELS WITH TEXT OVER TOP
	    //FOR EXAMPLE, GAME OVER SCENE
	    public static void setPanelBackground(JPanel panel, String imagePath) {	    	
	    	ImageIcon imageIcon = new ImageIcon(imagePath);
	    	JLabel background = new JLabel(imageIcon);
	    	
	    	background.setBounds(0,0,panel.getWidth(), panel.getHeight());
	    	panel.add(background);
	    }

	    
	    public JFrame visuals() { 
	    	JFrame frame = new JFrame("gaming");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        //good game window size
	        frame.setSize(960, 540);


	        JPanel buttonPanel = new JPanel();

	        //buttons
	        JButton back = addButton("Go Back", (ActionEvent e) -> {

	        	showPreviousCard();

	        });

	        buttonPanel.add(back);

	        JButton choice1 = addButton(Navigation.goLeft(Navigation.currentLocation),(ActionEvent e) -> {	        	
	        	System.out.println(currentLocation);
	        	showNextCard();

	        });


	       buttonPanel.add(choice1);

	        JButton choice2 = addButton(Navigation.goRight(Navigation.currentLocation),(ActionEvent e) -> {
	        	System.out.println(currentLocation);
	        	showNextCard();

	        });

	        buttonPanel.add(choice2);

//Frame components 
	        
	        frame.add(getCardPanel(), BorderLayout.CENTER);
	        frame.add(buttonPanel, BorderLayout.SOUTH);
	        frame.setVisible(true);
	        
	         actionPerformedLeft(choice1, choice2, e -> {	
	   
	        	});
	        
		return frame;
	    }
	    	
	    	/*  JFrame frame = new JFrame("gaming");
		        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		       
		        //good game window size
		        frame.setSize(1920, 1080);}
	    
		       //Create Buttton Panel
		       JPanel buttonPanel = new JPanel();
		        
		     // Create menu panel
		        JPanel menuPanel = new JPanel(new BorderLayout());
		        menuPanel.setBackground(Color.BLACK);

		        // Load menu image
		        String menuImg = "resources/WelcomeScreen.jpg";
		        ImageIcon menuIcon = new ImageIcon(menuImg);
		        JLabel menuLabel = new JLabel(menuIcon);
		        menuPanel.add(menuLabel, BorderLayout.CENTER);*/

		        // Create buttons for the menu
		      //  JButton startButton = new JButton("Start Game");
		     //   JButton exitButton = new JButton("Exit");

		     /*   startButton.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                // Handle start button action
		                // For example, switch to the game panel
		                cardLayout.show(cardPanel, "game");
		            }
		        });

		        exitButton.addActionListener(new ActionListener() {
		            @Override
		            public void actionPerformed(ActionEvent e) {
		                // Handle exit button action
		                // For example, exit the game
		                System.exit(0);
		            }
		        });
		        
		        JPanel buttonPanel1 = new JPanel();
		        buttonPanel1.add(startButton);
		        buttonPanel1.add(exitButton);
		        
		        menuPanel.add(buttonPanel1,BorderLayout.SOUTH);
		        
		        //Adding menu panel and game panel
		        frame.getContentPane().add(menuPanel);
		        frame.pack();
		        frame.setVisible(true);
		        
		        return frame;
	    }*/
	    
	    public JFrame createButtonFrame() {
	    	JFrame buttonFrame = new JFrame("Buttons");
	    	buttonFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    //Create button panel
	    	JPanel buttonPanel = new JPanel();
	    	
	    	//add button to panel 1 
	    	JButton back = addButton("Go Back", (ActionEvent e) -> {
		        	
		        	showPreviousCard();
		     
		        });
		        
		        buttonPanel.add(back);

		        JButton choice1 = addButton(Navigation.goLeft(Navigation.currentLocation),(ActionEvent e) -> {	        	
		        	
		        	showNextCard();
		       });
		        	        
		       buttonPanel.add(choice1);
		        
		       
		        JButton choice2 = addButton(Navigation.goRight(Navigation.currentLocation),(ActionEvent e) -> {
		        	showNextCard();
		        });
		        
		        buttonPanel.add(choice2);
		        
//add button to frame components 
		        buttonFrame.getContentPane().add(buttonPanel);
		        buttonFrame.pack();
		        buttonFrame.setVisible(true);
	    	
			return buttonFrame;
			}
    	
	    
      /*  public static class ImagePanel extends JPanel {
	    	private Image backgroundImage;
	    	
	    	public ImagePanel(String currentLocImg) {
	    		this.backgroundImage = new ImageIcon(currentLocImg).getImage();
	    	}
	    	@Override
	    	protected void paintComponent(Graphics g) {
	    		super.paintComponent(g);
	    		g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);  		
	    	}   	
	    } */
}
