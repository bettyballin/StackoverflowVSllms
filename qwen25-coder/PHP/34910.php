<?php\n\n    // Define the target directory where files should be moved\n    $targetDirectory = "./uploads/";\n\n    // Ensure the target directory exists, create if not\n    if (!is_dir($targetDirectory)) {\n        mkdir($targetDirectory, 0755, true);\n    }\n\n    // Check file size before moving it\n    if ($_FILES['Filedata']['size'] >= 5200) {  // Corrected the size limit to match your description (5.2KB or 5200 bytes)\n        echo "\n Sorry, Not Moved: Size should be below 5.2kb or 5200 bytes Only\n";\n        return;\n    }\n\n    // Get file extension\n    $ext = end(explode('.', strtolower($_FILES['Filedata']['name'])));\n\n    // Define the full path to move the file to\n    $targetFilePath = $targetDirectory . basename($_FILES['Filedata']['name']);\n\n    // Move the uploaded file to the specified directory\n    if (move_uploaded_file($_FILES['Filedata']['tmp_name'], $targetFilePath)) {\n        echo "\n File moved Successfully\n";\n        return;\n    } else {\n        echo "\n File move failed\n";\n    }\n?>