if ($_SERVER["REQUEST_METHOD"] == "POST") {\n    if (isset($_FILES['Filedata'])) {\n        // Process the upload\n        $file = $_FILES['Filedata'];\n        \n        // Example: Move the uploaded file to a new location\n        $targetDir = "uploads/";\n        $targetFile = $targetDir . basename($file["name"]);\n        if (move_uploaded_file($file["tmp_name"], $targetFile)) {\n            echo "The file ". htmlspecialchars( basename( $file["name"])). " has been uploaded.";\n        } else {\n            echo "Sorry, there was an error uploading your file.";\n        }\n    } else {\n        echo "No file was uploaded.";\n    }\n}