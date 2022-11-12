import java.lang.reflect.InaccessibleObjectException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;
import javax.lang.model.util.ElementScanner14;

public class Driver {
   
    static Location currLocation; 
    static ContainerItem myInventory = new ContainerItem("bagback", "bag", "a blue totebag"); 

    public static void createWorld()
    {
        Location hallway = new Location("hallway", " a dark mysterious alley"); 
        Location bedroom = new Location("bedroom", " a pink cozy space with a fireplace"); 
        Location kitchen = new Location("kitchen", "a room with white marble shelves and fresh fruits on display"); 
        Location bathroom = new Location ("bathroom", "a crammed space with crimson tiles"); 
        hallway.connect("east", bedroom); 
        bedroom.connect("west", hallway); 
        hallway.connect("south", bathroom); 
        bathroom.connect("north", hallway);
        hallway.connect("north", kitchen); 
        kitchen.connect("south", hallway); 
        Item chicken = new Item ("chicken", "food", "a freshly baked chicken dish"); 
        Item lamp = new Item ("lamp", "lighting", "a metallic table lamp"); 
        Item painting = new Item ("painting", "art piece", "a giant painting of a woman");
        Item toothbrush = new Item ("toothbrush", "bathroom accessory", "a blue electricc toothbrush");
        kitchen.addItem(chicken); 
        bedroom.addItem(lamp); 
        hallway.addItem(painting); 
        bathroom.addItem(toothbrush); 
        currLocation = hallway; 

    }
    public static void helperFunction()
    {
        System.out.println("quit: exits the program" + "\n" + "look: shows the name of the current location"+ "\n"+ "examine: shows the name, type and description of the item to be examined"+ "\n"+ "go: takes the user to a new location in the direction entered" + "\n" + "inventory: displays the names of the items currently in the inventory" + "\n" + "take: takes the item from the current location and adds it to your inventory" + "\n" + "drop: drops an item from the inventory at the current location"); 
    }
    public static void main (String[]args)
    {
        currLocation = new Location("Kitchen", "where food is made"); 
        Item knife = new Item("Knife", "Tool", "A sharp killing device");
        Item turkey = new Item("Turkey", "Food", "Not a chicken");
        Item plate = new Item("Plate", "Utensil", "Something to eat food in");
        currLocation.addItem(knife);
        currLocation.addItem(turkey);
        currLocation.addItem(plate);
        Scanner myObj = new Scanner(System.in); 
        myInventory.addItem(plate);
        createWorld(); 

        for (;;)
        {
                System.out.println("Enter Command"); 
                String command = myObj.nextLine();

            String [] commandArray = command.split(" "); 
            switch (commandArray[0])
            {
                case "quit":
                System.exit(0);
                break;

                case "look":
                System.out.println(currLocation.getName() + " - " + currLocation.getDescription()); 
                for (int i = 0; i < currLocation.numItems(); i++)
                {
                    System.out.println("+ " + currLocation.getItem(i).getName()); 
                }
                break;
                case "examine": 
                    if (commandArray.length == 2)
                    {
                         if (currLocation.hasItem(commandArray[1]))
                        {
                            Item examinedItem = currLocation.getItem(commandArray[1]); 
                            System.out.println(examinedItem.toString());
                            break;
                        }
                            
                        else
                        {
                            System.out.println("Item not found"); 
                            break;
                        }  

                    }
                       
                    else 
                    {
                        System.out.println("You have not entered an Item to examine"); 
                        break; 
                    } 
                case "go": 
       
                if (commandArray.length == 2)
                {
                    if(commandArray[1].equalsIgnoreCase("north") || commandArray[1].equalsIgnoreCase("south") || commandArray[1].equalsIgnoreCase("east") || commandArray[1].equalsIgnoreCase("west"))
                    {
                        if (currLocation.canMove(commandArray[1]))
                        {
                            currLocation = currLocation.getLocation(commandArray[1]);
                            System.out.println(currLocation.getName());  
                            break;
                        }

                     else
                    {
                        System.out.println("You cannot move there"); 
                        break;
                    }
                    }

                    else
                    {
                        System.out.println("Please enter a valid direction");   
                        break;  
                    }
                        
                }
                else
                {
                    System.out.println("You have not entered a direction"); 
                    break;
                }

                case "inventory":
                if(myInventory == null)
                {
                    System.out.println("You have no items in your inventory right now");
                }
                else{

                System.out.println(myInventory.toString()); 
                break; 
                }

                case "take":
                if(commandArray.length == 2)
                {
                    if(currLocation.hasItem(commandArray[1]))
                {
                    Item takenItem = currLocation.getItem(commandArray[1]); 
                    currLocation.removeItem(takenItem.getName()); 
                    myInventory.addItem(takenItem);
                    System.out.println(takenItem.getName() + " taken"); 
                    break; 
                }
                else
                {
                    System.out.println("Cannot find that item here"); 
                    break; 
                }
                }
                else
                {
                    System.out.println("Please enter the name of the item you want to take"); 
                    break; 
                }
                

                case "drop":
                if(commandArray.length == 2)
                {
                    if(myInventory.hasItem(commandArray[1]))
                {   
                    Item droppedItem = myInventory.removeItem(commandArray[1]); 
                    currLocation.addItem(droppedItem); 
                    System.out.println(droppedItem.getName() + " dropped at " + currLocation.getName()); 
                    break; 

                }
                else
                {
                    System.out.println("Cannot find that item in your inventory"); 
                    break; 
                }
                }
                else 
                {
                    System.out.println("Please include the item you would like to drop"); 
                    break; 
                }
                

                case "help":
                helperFunction(); 
                break; 
               
                default: 
                System.out.println("I don't know how to do it");
        }                 
    }
}
} 


