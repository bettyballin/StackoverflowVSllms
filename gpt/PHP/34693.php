$local_path = '/path/to/your_server/your_desired_name.zip';\n    $new_filename = 'your_desired_name.zip';\n\n    // Set headers to force download\n    header('Content-Type: application/zip');\n    header('Content-Disposition: attachment; filename="' . $new_filename . '"');\n    header('Content-Length: ' . filesize($local_path));\n\n    // Read the file and output it to the browser\n    readfile($local_path);