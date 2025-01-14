<?php\n// Start session and include necessary files\nsession_start();\ninclude "../../functions.php"; \nstart($_REQUEST['PHPSESSID']);\ninclude "../../inc/photo.php";\n\nif(!is_logged_in()) {\n    echo "0";\n    exit;\n}\n\n$fail = false;\n\n// Check for upload errors\nforeach ($_FILES as $file) {\n    if ($file['error'] === UPLOAD_ERR_OK) {\n        // Proceed with the file processing\n        if(add_to_album($file['tmp_name'], $_REQUEST['album']) == false) {\n            $fail = true;\n        }\n    } else {\n        // Handle upload errors according to error code\n        switch ($file['error']) {\n            case UPLOAD_ERR_INI_SIZE:\n            case UPLOAD_ERR_FORM_SIZE:\n                echo "File size too big.";\n                $fail = true;\n                break;\n            default:\n                echo "Failed to move uploaded file: " . $file['tmp_name'];\n                $fail = true;\n        }\n    }\n}\n\nif($fail == true) {\n    echo "0";\n} else {\n    echo "1";\n}