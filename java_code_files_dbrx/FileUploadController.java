import java.lang.String;

public class FileUploadController {
    @PutMapping(value="/path-to-resource", consumes = {"multipart/form-data"}, produces = "application/xml")
    public ResponseEntity<YourResponseObject> updateResource(@RequestPart("file") MultipartFile file, @Valid @ModelAttribute YourInputObject input){
        // Perform your operations here ...
    }
    public static void main(String[] args) {
    }
}

@interface PutMapping {
    String value();
    String[] consumes();
    String produces();
}

@interface RequestPart {
    String value();
}

@interface Valid {}

@interface ModelAttribute {}

class ResponseEntity<T> {
    // minimal stub
}

class MultipartFile {
    // minimal stub
}

class YourResponseObject {
    // minimal stub
}

class YourInputObject {
    // minimal stub
}