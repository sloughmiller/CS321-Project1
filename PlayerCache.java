import java.util.ArrayList;
import java.util.Collection;

public class PlayerCache <T> 
{

    private int cacheSize;
    private int hits;
    private int misses;
    private int count;
    Player player = new Player(null, 0.0);
    ArrayList<Player> alPlayers = new ArrayList<>();
    String name = player.getName();
    double balance = player.getBalance();


    //constructor method
    public PlayerCache(int cacheSize)
    {
        this.cacheSize = cacheSize;
    }

    //getplayer method
    
    public ArrayList<Player> getObject(String name)
     {
        
        ArrayList<Player> results = alPlayers;
        for (Player searchPlayer : alPlayers) {
            if (alPlayers.contains(name)) {
                results.add(searchPlayer);
                this.hits++;
            }
            else
            {
                this.misses++;
            }
        }
        return results;
    }

    //addplayer method
    public void addObject(Player newPlayer)
    {
        if(count == cacheSize)
        {
            alPlayers.remove(alPlayers.size()-1);
            count--;
        }

        alPlayers.add(newPlayer);
        count++;
    }

    //removeplayer method

    public void removeObject(Player removePlayer)
    {
        for (Player searchPlayer : alPlayers) {
            if (alPlayers.contains(removePlayer)) {
                alPlayers.remove(removePlayer);
                this.count--;
            }
    }

    //clear cache method

    public void clearCache()
    {
        alPlayers.clear();
        count = 0;
    }

    //toString method

    @Override
    public String toString()
    {
        return "Total number of references:          " + cacheSize + 
               "\nTotal number of cache hits:             " + hits +
               "\nCache hit ratio:                        " + ((hits/cacheSize)*100)+"%\n";
    }




}