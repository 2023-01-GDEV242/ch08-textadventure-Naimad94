import java.util.HashMap;

/**
 * Write a description of class Item here.
 *
 * @name Damian Nunez
 * @date 032723
 */
public class Item
{
    private String description; //description of the item.
    private int weight; //weight of the item.
    
    /**
     * Constructor for objects of class Item
     */
    
    public Item(String description, int weight)
    {
        this.description = description; //Gives the description.
        this.weight = weight; //Gives the weight.
    }
    
    public String getDescription()
    {
        return description;
    }
}
