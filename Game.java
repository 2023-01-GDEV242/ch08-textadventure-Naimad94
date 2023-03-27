/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Damian Nunez
 * @date    03.13.2023
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room mainEntrance, lowerLibrary, livingRoom, courtyard, dinningHall , kitchen, pool, danceHall, 
        kitchenStorage, upperLibrary, upperMainEntrance, musicRoom;
      
        // create the rooms
        mainEntrance = new Room("Main entrance of the mansion");
        lowerLibrary = new Room("In a library");
        livingRoom = new Room("In a living room");
        courtyard = new Room("Outside in a courtyard");
        dinningHall = new Room("In the dinnning hall");
        kitchen = new Room("In the kitchen");
        pool = new Room("In the indoor pool");
        danceHall = new Room("In the dance room");
        kitchenStorage = new Room("In the kitchen Storage");
        upperLibrary = new Room("In the upper library");
        upperMainEntrance = new Room("In the upper Main Entrance");
        musicRoom = new Room("In the music Room");
        
        // initialise room exits
        mainEntrance.setExit("west", lowerLibrary);
        mainEntrance.setExit("up", upperMainEntrance);
        mainEntrance.setExit("north", courtyard);
        mainEntrance.setExit("east", livingRoom);
        
        courtyard.setExit("north", pool);
        courtyard.setExit("east", danceHall);
        courtyard.setExit("south", mainEntrance);
        courtyard.setExit("west", dinningHall);
        
        lowerLibrary.setExit("north", dinningHall);
        lowerLibrary.setExit("up", upperLibrary);
        lowerLibrary.setExit("east", mainEntrance);
        
        livingRoom.setExit("north", danceHall);
        livingRoom.setExit("west", mainEntrance);

        currentRoom = mainEntrance;  // start game outside
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) 
        {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
            
            //Exercise 8.14 Added look command.    
            case LOOK:
                lookAround();
                break;
              
            //Exercise 8.15 Added Eat command.    
            case EAT:
                eatFood();
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
        
        /*
         * "Estas perdido. Estas solo. Te deambulas"
         * "alrededor de la mansion"
         * 
         * "tus palabras de mando son: "
         * 
         * "Chinkasqanam kachanki. Sapallan kanki. Purinki."
         * "hatun wasi muyuriqpi"
         * 
         * "Kamachiyniyki simikunaqa: "
         * 
         */
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            System.out.println("Ir a donde?"); //Spanish translation.
            System.out.println("Mayman riy?"); //Quechua translation.
            
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) 
        {
            System.out.println("There is no door!");
            System.out.println("No hay puerta!"); //Spanish translation.
            System.out.println("Mana punku kanchu!"); //Quechua translation.
        }
        else 
        {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) 
        {
            System.out.println("Quit what?");
            System.out.println("Salir de que?");
            System.out.println("Saqiy imata?");
            
            return false;
        }
        else 
        {
            return true;  // signal that we want to quit
        }
    }
    
    
    /*
     * "LOOK" was entered. Will give a brief description of what is in current area.
     */
    public void lookAround()
    {
            System.out.println(currentRoom.getLongDescription());
    }
    
    /*
     * "EAT" was entered. Will eat if food is available.
     * Food would prob be a boolean statement.
     */
    public void eatFood()
    {
        System.out.println("Delicous");
    }
}
