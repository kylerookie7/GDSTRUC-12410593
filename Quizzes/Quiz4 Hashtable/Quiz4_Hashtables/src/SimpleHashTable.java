import java.awt.desktop.SystemEventListener;


public class SimpleHashTable {
    private SavedPlayer[] hashtable;


    public SimpleHashTable() {
        hashtable = new SavedPlayer[10];
    }


    public int hashKey(String key){
        return key.length() % hashtable.length;
    }


    public int findKey(String key){
        int hashedKey = hashKey(key);


        // already correct hashed key
        if(isOccupied(hashedKey) && hashtable[hashedKey].getKey().equals(key)){
            return hashedKey;
        }


        // perform linear probing
        int stoppingIndex = hashedKey;


        if(hashedKey == hashtable.length - 1){ // end of the array
            hashedKey = 0;
        }
        else{
            hashedKey++;
        }


        while(hashedKey != stoppingIndex &&
                isOccupied(hashedKey) &&
                !hashtable[hashedKey].getKey().equals(key)){
            hashedKey = (hashedKey + 1) % hashtable.length;
        }


        if(isOccupied(hashedKey) && hashtable[hashedKey].getKey().equals(key)){ // saved player found
            return hashedKey;
        }


        return -1;
    }


    public boolean isOccupied(int hashedKey){
        return hashtable[hashedKey] != null;
    }


    public void put(String key, Player value){
        int hashedKey = hashKey(key);


        // perform linear probing
        if(isOccupied(hashedKey)){
            int stoppingIndex = hashedKey;


            if(hashedKey == hashtable.length - 1){ // hashed key is already at the end of the array
                hashedKey = 0;
            }
            else{
                hashedKey++;
            }


            while(hashedKey != stoppingIndex && hashtable[hashedKey]  != null){
                hashedKey = (hashedKey + 1) % hashtable.length;
            }
        }


        if (isOccupied(hashedKey)){ //hashed key is already taken
            System.out.println("Cannot put player " + key + ". Hashtable is full.");
        }
        else{
            hashtable[hashedKey] = new SavedPlayer(key, value);
        }
    }


    public Player get(String key){
        int hashedKey = findKey(key);


        if(hashedKey == -1){
            return null;
        }


        return hashtable[hashedKey].getValue();
    }


    public Player remove(String key){
        int hashedKey = findKey(key);


        if(hashedKey == -1){
            System.out.println("Player with key " + key + " not found.");
            return null;
        }


        Player removedPlayer = hashtable[hashedKey].getValue();


        hashtable[hashedKey] = null;


        SavedPlayer[] oldHashtable = hashtable;
        hashtable = new SavedPlayer[oldHashtable.length];


        for(SavedPlayer saved : oldHashtable){
            if(saved != null){
                put(saved.getKey(), saved.getValue());
            }
        }


        System.out.println("Player " + key + " has been removed.");
        return removedPlayer;
    }


    public void printHashtable(){
        for (int i = 0;i < hashtable.length; i++){
            Player player = null;


            if(hashtable[i] != null)
                player =hashtable[i].getValue();


            System.out.println("Element " + i + " = " + player);
        }
    }
}
