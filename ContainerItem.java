import java.util.ArrayList;

public class ContainerItem extends Item
{
private ArrayList <Item> items; 

public ContainerItem ( String cName, String cType, String cDescription)
{
    super(cName, cType, cDescription); 
    items = new ArrayList <Item> (); 
}

public void addItem (Item obj)
{
    items.add(obj); 
}
public boolean hasItem(String name)
{
    boolean isThere = false;

    for (int i = 0; i < items.size(); i++) 
    {
        if (items.get(i).getName().equalsIgnoreCase(name))
        {
            isThere = true;
        }
    }
    return isThere;
}
public Item removeItem(String name)
{
    Item itemName = null; 
    for (int i = 0; i < items.size(); i++)
    {
        if(items.get(i).getName().equalsIgnoreCase(name))
        {
            itemName = items.get(i); 
            items.remove(i); 
        }
    }
    return itemName; 
}
@Override
public String toString()
{
    String str1 = this.getName() + " [ " + this.getType() + " ] : " + this.getDescription() + ":"; 
    for(int i = 0; i < items.size(); i++)
    {
        String str2 = "+" + items.get(i).getName(); 
         str1 = str1 + "\n" + str2; 
    }
    return str1; 
}

}