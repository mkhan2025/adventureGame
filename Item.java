public class Item
{
    private String name; 
    private String type; 
    private String description; 

    public Item(String name, String type, String description){
        this.name = name;
        this.type = type;
        this.description = description;
    }
    public String getName()
    {
        return name; 
    }
    public String getType()
    {
        return type; 
    }
    public String getDescription()
    {
        return description; 
    }
    public void setName(String newName)
    {
        name = newName;
    }
    public void setType(String newType)
    {
        type = newType;
    }
    public void setDescription(String newDes)
    {
        description = newDes;
    }
    public String toString()
    {
        return this.name + " [" + this.type + "]: " + this.description;
    }
}