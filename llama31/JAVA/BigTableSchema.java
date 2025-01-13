import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.models.ColumnFamily;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.Table;

public class BigTableSchema {
  public static void main(String[] args) {
    // Create a BigTable client instance
    BigtableTableAdminClient adminClient = BigtableTableAdminClient.create();

    // Define the column families
    ColumnFamily profileFamily = ColumnFamily.newBuilder("profile").build();
    ColumnFamily addressFamily = ColumnFamily.newBuilder("address").build();
    ColumnFamily ordersFamily = ColumnFamily.newBuilder("orders").build();

    // Create the table
    Table table =
        adminClient.createTable(
            CreateTableRequest.newBuilder(adminClient.getTableId("my-instance", "user_data"))
                .addFamily(profileFamily)
                .addFamily(addressFamily)
                .addFamily(ordersFamily)
                .build());

    System.out.println("Table created: " + table.getName());
  }
}