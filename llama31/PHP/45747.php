$chunkSize = 1024 * 1024; // 1MB chunks\n$data = $_POST['textarea_data'];\n$chunks = str_split($data, $chunkSize);\n\nforeach ($chunks as $chunk) {\n    // Process each chunk individually\n    processChunk($chunk);\n}\n\nfunction processChunk($chunk) {\n    // Your processing logic here\n}