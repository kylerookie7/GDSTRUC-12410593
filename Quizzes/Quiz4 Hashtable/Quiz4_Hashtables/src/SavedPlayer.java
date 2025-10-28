public class SavedPlayer {
    private String key;
    private Player Value;


    public SavedPlayer(String key, Player value) {
        this.key = key;
        Value = value;
    }


    public String getKey() {
        return key;
    }


    public void setKey(String key) {
        this.key = key;
    }


    public Player getValue() {
        return Value;
    }


    public void setValue(Player value) {
        Value = value;
    }
}
