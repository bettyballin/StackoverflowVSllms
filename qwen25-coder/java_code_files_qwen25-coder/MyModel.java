import java.lang.String;

@Component
public class MyModel {

    public MyViewModel createViewModel(Data data) {
        // Transform data to ViewModel
        return new MyViewModel(data);
    }

    public static void main(String[] args) {
    }
}

@interface Component {
    // Annotation definition
}

class Data {
    // Data class definition
}

class MyViewModel {
    public MyViewModel(Data data) {
        // Constructor implementation
    }
}