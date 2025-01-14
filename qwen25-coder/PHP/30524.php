<?php\nif ($_SERVER["REQUEST_METHOD"] == "POST") {\n    $target_dir = "uploads/";\n    $target_file = $target_dir . basename($_FILES["fileToUpload"]["name"]);\n    $uploadOk = 1;\n    $imageFileType = strtolower(pathinfo($target_file,PATHINFO_EXTENSION));\n\n    // Check if image file is a actual image or fake image\n    $check = getimagesize($_FILES["fileToUpload"]["tmp_name"]);\n    if($check !== false) {\n        echo "File is an image - " . $check["mime"] . ".";\n        $uploadOk = 1;\n    } else {\n        echo "File is not an image.";\n        $uploadOk = 0;\n    }\n\n    // Check if file already exists\n    if (file_exists($target_file)) {\n        echo "Sorry, file already exists.";\n        $uploadOk = 0;\n    }\n\n    // Check file size\n    if ($_FILES["fileToUpload"]["size"] > 500000) {\n        echo "Sorry, your file is too large.";\n        $uploadOk = 0;\n    }\n\n    // Allow certain file formats\n    if($imageFileType != "jpg" && $imageFileType != "png" && $imageFileType != "jpeg"\n    && $imageFileType != "gif" ) {\n        echo "Sorry, only JPG, JPEG, PNG & GIF files are allowed.";\n        $uploadOk = 0;\n    }\n\n    // Check if $uploadOk is set to 0 by an error\n    if ($uploadOk == 0) {\n        echo "Sorry, your file was not uploaded.";\n    // if everything is ok, try to upload file\n    } else {\n        if (move_uploaded_file($_FILES["fileToUpload"]["tmp_name"], $target_file)) {\n            echo "The file ". basename( $_FILES["fileToUpload"]["name"]). " has been uploaded.";\n        } else {\n            echo "Sorry, there was an error uploading your file.";\n        }\n    }\n}\n?>