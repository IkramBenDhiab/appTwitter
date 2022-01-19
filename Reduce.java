public class Reduce extends Reducer<NullWritable, Text, NullWritable, Text>
    private PriorityQueue<User> followersPriorityQueue = new PriorityQueue<>();
    public void reduce(NullWritable key, Iterable<Text> values, Context context)
            throws IOException, InterruptedException {
        for (Text value : values){
            String line = value.toString();
            String[] data = line.split("\t");
            int followers = Integer.parseInt(data[1])
            
            User user = followersPriorityQueue.peek();
            if(followersPriorityQueue.size() <= 3 || followers > user.getFollowers()){
                followersPriorityQueue.add(new User(followers, new Text(value)));
                if(followersPriorityQueue.Size() > 3)){
                    followersPriorityQueue.remove(user);

                }
            }
        
        }
            }
