public class Main extends Configured implements Tool {
    public int run(String[] args) throws Exception{
        Job job = job.getinstance(getConf());
        job.setJobName("filter");
        job.setJarByClass(Main.class);

        job.setOutputKeyClass(NullWritable.class);
        job.setOutputValueClass(Text.class);

        job.setMapperClass(Map.class);
        job.setReducerClass(Reducer.class); 
        Path inputFilePath = new Path("/Users/census.txt");
        Path outputFilePath = new Path("/Users/output");
        FileInputFormat.addInputPath(job, inputFilePath);
        FileOutputFormat.setOutputPath(job, outFilePath);
        
        return job.waitForCompletion(true) ? 0 : 1;
    }
        public static void main(String[] args) throws Exception {
            int exitCode = ToolRunner.run(new Main(), args);
            System.exit(exitCode);        
        }
}
