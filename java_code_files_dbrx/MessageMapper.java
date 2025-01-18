public class MessageMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public IMyMessageData mapLIveToCommon(MyLiveMessageData liveMessage) {
        return modelMapper.map(liveMessage, IMyMessageData.class); // Convert/map from MyLiveMessageData to common Interface type 'IMyMessageData'.
    }

    public IMyMessageData mapTestToCommon(MyTestMessageData testMessage) {
        return modelMapper.map(testMessage, IMyMessageData.class); // Convert/map from MyTestMessageData to common Interface type 'IMyMessageData'.
    }

    public static void main(String[] args) {
        // Main method
    }
}

// Define the IMyMessageData interface
interface IMyMessageData {
    // Interface methods (if any)
}

// Define the MyLiveMessageData class
class MyLiveMessageData {
    // Class fields and methods (if any)
}

// Define the MyTestMessageData class
class MyTestMessageData {
    // Class fields and methods (if any)
}

// Define the ModelMapper class with a map method
class ModelMapper {
    public <S, D> D map(S source, Class<D> destinationType) {
        // Mapping logic (stubbed for compilation)
        return null;
    }
}