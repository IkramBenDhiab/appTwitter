import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mappreduce.Mapper;

import java.io.IOException;
import org.util.PriorityQueue;
public class Map extends Mapper<LongWritable, Text, NullWritable, Text>
    private PriorityQueue<User> followersPriorityQueue = new PriorityQueue<>();
    public void map(LongWritable key,Text Value, Context context)
            throws IOException, InterruptedException {
                String line = Value.toString();
                String[]data = line.split('\t');
                Integer followers = Integer.parseInt(data[1]);
        User user = followers.PriorityQueue.peek();
        if (followersPriorityQueue.Size() <= 3 || followers > user.getFollowers()){
            followersPriorityQueue.add(new User(followers, new Text(value)));
            if (followersPriorityQueue.Size() > 3){
                followersPriorityQueue.poll();
            }
        }
        

            }
        while (!followersPriorityQueue.isEmpty()){
            context.write(NullWritable.get(),followersPriorityQueue.poll().getRecord());
        }
