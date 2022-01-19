public class User implements Comparable<Users> {
    private int followers;
    private Text record;
     
    public User(int followers, Text record) {
        this.followers = followers;
        this.record = record;

    }

    public int getFollowers(){
        return followers;
    }

    public Text getRecord(){
        return record;
    }

    public int CompareTo(User user){ 
        return this.followers - user.followers;
    }
}
