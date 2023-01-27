import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class CacheTest {
    
    public static ArrayList<Player> deserializePlayers(String fileName)
    {
        ArrayList<Player> players = new ArrayList<Player>();
        try{
            FileInputStream fileI = new FileInputStream(fileName);
            ObjectInputStream objectI = new ObjectInputStream(fileI);
            players = (ArrayList<Player>)objectI.readObject();
            fileI.close();
            objectI.close();
        }
        catch(IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        
        
        return players;
        
    }

    public static void main(String[] args)
    {
        int cacheSize = Integer.parseInt(args[0]);
        String fileName = args[1];
        ArrayList<Player> players = deserializePlayers(fileName);

        PlayerCache cache = new PlayerCache<>(cacheSize);

        for(Player player : players)
        {
            cache.addObject(player);
        }

        System.out.println(cache.toString());


    }

}
