$file_path = 'path/to/your/file.jpg';\nif (file_exists($file_path)) {\n    if (unlink($file_path)) {\n        echo 'File deleted successfully';\n    } else {\n        echo 'Error deleting file';\n    }\n} else {\n    echo 'File does not exist';\n}