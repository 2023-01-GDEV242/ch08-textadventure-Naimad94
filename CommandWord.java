/**
 * Representations for all the valid command words for the game
 * along with a string in a particular language.
 * 
 * @author  Damian Nunez
 * @date    03.13.2023
 */
public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    //Exercise 8.14 and 8.15 added LOOk command and EAT command.
    
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), LOOK("look"),
    EAT("eat"), BACK("back"), MARK("mark");
    
    // The command string.
    private String commandString;
    
    /**
     * Initialise with the corresponding command string.
     * @param commandString The command string.
     */
    CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}
