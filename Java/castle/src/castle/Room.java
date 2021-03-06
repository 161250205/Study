package castle;

import java.util.HashMap;

public class Room {
    public String description;
    private HashMap<String,Room> exits= new HashMap<String,Room>();  

    public Room(String description) 
    {
        this.description = description;
    }

    public void setExit(String direction,Room room) 
    {
        exits.put(direction, room);
    }
    
    public Room Exit(String direction){
    	Room nextRoom=null;
    	if(direction.equals("north")) {
            nextRoom = exits.get("north");
        }
        if(direction.equals("east")) {
        	nextRoom = exits.get("east");
        }
        if(direction.equals("south")) {
        	nextRoom = exits.get("south");
        }
        if(direction.equals("west")) {
        	nextRoom = exits.get("west");
        }
    	return nextRoom;
    }
    
    public String showExits(){
    	StringBuffer se= new StringBuffer();
    	for(String dir : exits.keySet())
    	{
    		se.append(dir);
    		se.append(" ");
    	}
    	return se.toString();
    }

    @Override
    public String toString()
    {
        return description;
    }
}
