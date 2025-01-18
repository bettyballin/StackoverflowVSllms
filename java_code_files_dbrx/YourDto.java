// Use reflection-based mapping libraries like OpenCSV or SuperCSV here on DTO.

public class YourDto {
    private String col1;
    private int col2;
    // ... and so on
}

public class YourModelObject {
    // Fields and methods
}

public interface Mapper<S, T> {
    public T mapTo(final S source);
}

public class MappingFunction implements Mapper<YourDto, YourModelObject> {
    @Override
    public YourModelObject mapTo(final YourDto dto) {
        // Return a new instance of your Java model object where fields are set using data from DTO.
        return new YourModelObject();
    }

    public static void main(String[] args) {
    }
}