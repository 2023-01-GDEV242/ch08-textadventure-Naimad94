import java.util.HashMap;

/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    private String description; //description of the item.
    private HashMap<String,Room> exits;
    private boolean take;
    
    /**
     * Constructor for objects of class Item
     */
    
    public Item(String description)
    {
        this.description = description;
        exits = new HashMap<String, Room>();
    }
    
    public boolean take()
    {
        return true;
    }
}
