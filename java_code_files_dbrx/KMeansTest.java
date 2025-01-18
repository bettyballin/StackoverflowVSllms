// Example of k-means clustering using Apache Mahout
import org.apache.mahout.math.VectorWritable;
import org.apache.hadoop.conf.Configuration;
import org.apache.mahout.clustering.kmeans.KMeansDriver;
import org.apache.hadoop.fs.Path;

public class KMeansTest {
  public static void main(String[] args) throws Exception {
    Configuration conf = new Configuration();
    KMeansDriver.run(conf, new Path("input"), new Path("output"),
      new Path("clustersIn"), new Path("clustersOut"), false);
  }
}