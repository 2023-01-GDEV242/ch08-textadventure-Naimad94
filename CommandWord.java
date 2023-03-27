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
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?");
    
    
    /*
     * validCommands = new HashMap<>();
     * validCommands.put("go", CommandWord.GO);
     * validCommands.put("help", CommandWord.HELP);
     * validCommands.put("quit", CommandWord.QUIT);
     * 
     * Spanish Commands
     * validCommands.put("ir", CommandWord.GO);
     * validCommands.put("ayuda", CommandWord.HELP);
     * validCommands.put("salir", CommandWord.QUIT);
     * 
     * Quechua Commands
     * validCommands.put("riy", CommandWord.GO);
     * validCommands.put("yanapay", CommandWord.HELP);
     * validCommands.put("lluqsiy", CommandWord.QUIT);
     */
    
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
