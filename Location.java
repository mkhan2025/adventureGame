import java.util.ArrayList;
import java.util.HashMap;

public class Location 
{
    private String name;
    private String description;
    private ArrayList<Item> list;
    private HashMap <String, Location> connection; 

    public Location(String name, String description)
    {
        this.name = name; 
        this.description = description; 
        list = new ArrayList<Item>(); 
        connection = new HashMap <String, Location>(); 
    }

    public void connect (String dirName, Location loc)
    {
        connection.put(dirName, loc); 
    }

    public boolean canMove(String dirName)
    {
       return connection.containsKey(dirName.toLowerCase()); 
    }
    
    public Location getLocation(String dirName)
    {
        if(connection.containsKey(dirName.toLowerCase()))
        {
            return connection.get(dirName.toLowerCase()); 
        }
        return null;
       
    }

    public String getName()
    {
        return name;
    }
    public String getDescription()
    {
        return description;
    }
    public void setName(String newName)
    {
        name = newName;
    }
    public void setDescription(String newDes)
    {
        description = newDes;
    }
    public void addItem (Item b)
    {
        list.add(b); 
    }
    public boolean hasItem(String itemName)
    {
        boolean isThere = false;

        for (int i = 0; i < list.size(); i++) 
        {
            if (list.get(i).getName().equalsIgnoreCase(itemName))
            {
                isThere = true;
            }
        }
        return isThere;
    }
    public Item getItem(String itemName)
    {
        Item b = null; 
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i).getName().equalsIgnoreCase(itemName))
            {
                b = list.get(i); 
            }       
        }
        return b; 
    }
    public Item getItem(int index)
    {
        Item c = null;
        
        if (index >= 0 && index < list.size()){
            c = list.get(index);
        }
        return c; 
    }
    public int numItems()
    {
        return list.size(); 
    }
    public Item removeItem(String itemName)
    {   Item d = getItem(itemName);
        list.remove(d);
        return d;
    }

}
