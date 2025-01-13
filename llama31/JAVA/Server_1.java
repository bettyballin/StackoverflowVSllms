import java.util.List;
import java.util.ArrayList;

// Server.java
class Server {
    private String name;
    private String ip;

    public Server(String name, String ip) {
        this.name = name;
        this.ip = ip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}

// Database.java
class Database {
    private String name;
    private Server server;

    public Database(String name, Server server) {
        this.name = name;
        this.server = server;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }
}

// Column.java
class Column {
    private String name;
    private Database database;

    public Column(String name, Database database) {
        this.name = name;
        this.database = database;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }
}

// Services
class ServerService {
    public List<Database> getServerDatabases(Server server) {
        // retrieve databases for the given server
        List<Database> databases = new ArrayList<>();
        // Add logic to populate databases
        return databases;
    }
}

public class DatabaseService {
    public List<Column> getDatabaseColumns(Database database) {
        // retrieve columns for the given database
        List<Column> columns = new ArrayList<>();
        // Add logic to populate columns
        return columns;
    }

    public static void main(String[] args) {
        Server server = new Server("MyServer", "192.168.1.1");
        Database database = new Database("MyDatabase", server);
        Column column = new Column("MyColumn", database);

        ServerService serverService = new ServerService();
        List<Database> databases = serverService.getServerDatabases(server);

        DatabaseService databaseService = new DatabaseService();
        List<Column> columns = databaseService.getDatabaseColumns(database);

        // Add logic to use databases and columns
    }
}