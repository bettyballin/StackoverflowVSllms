try {\n    if (file_exists('/path/to/file') && is_writable('/path/to/file')) {\n        $handle = fopen('/path/to/file', 'w');\n        // Perform file operations\n        fclose($handle);\n    } else {\n        // Display an error to user about file not existing or not being writable\n        echo "Error: The file does not exist or is not writable.";\n    }\n} catch (Exception $e) {\n    // Log the exception to a file\n    error_log($e->getMessage(), 3, '/path/to/error.log');\n    // Display an error to user about an unexpected error\n    echo "An unexpected error occurred. Please try again later.";\n}