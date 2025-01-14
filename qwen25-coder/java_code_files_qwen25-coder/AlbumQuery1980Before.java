import java.util.List;

public class AlbumQuery1980Before {
    DataStore datastore = new DataStore();

    Query<Album> query = datastore.createQuery(Album.class)
            .filter("publication_year <=", 1980L)
            .order("artist_name");

    List<Album> albums = query.asList();

    public static void main(String[] args) {
    }
}

class Album {
}

class Query<T> {
    public Query<T> filter(String condition, Long value) {
        return this;
    }

    public Query<T> order(String fieldName) {
        return this;
    }

    public List<T> asList() {
        return null;
    }
}

class DataStore {
    public <T> Query<T> createQuery(Class<T> clazz) {
        return new Query<T>();
    }
}