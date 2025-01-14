$pk = "some_unique_identifier"; // Ensure $pk is properly set and sanitized\n$PIC_URL = "http://example.com/image.jpg"; // Example URL, ensure it's properly set\n\nif (!empty($PIC_URL)) {\n    try {\n        $imageData = file_get_contents($PIC_URL);\n        \n        if ($imageData === FALSE) {\n            throw new Exception("Failed to fetch image from the URL.");\n        }\n        \n        if (!is_writable("./images/")) {\n            throw new Exception("The target directory is not writable.");\n        }\n\n        if (file_put_contents("./images/" . $pk . ".jpg", $imageData) === FALSE) {\n            throw new Exception("Failed to save the image file.");\n        }\n    } catch (Exception $e) {\n        error_log("An error occurred: " . $e->getMessage());\n        // Optionally, you can inform the user or handle it in a more user-friendly way\n    }\n} else {\n    error_log("PIC_URL is empty.");\n}