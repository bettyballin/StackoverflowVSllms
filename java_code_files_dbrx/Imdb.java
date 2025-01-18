public interface RatingProvider {
    String getRating(String movieName);
}

@FunctionalInterface
interface Supplier<T> {
    T get();
}

class Imdb implements RatingProvider {
    public String getRating(String movieName) {
        throw new UnsupportedOperationException();
    }
}

class MetaCritic implements RatingProvider {
    public String getRating(String movieName) {
        throw new UnsupportedOperationException();
    }
}