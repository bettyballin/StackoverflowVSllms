<?php\n$tsv_content = "Hey\tThese\tAre\tTab\tSeperated\tValues\n";\n$tsv_content .= "Hey\tThese\tAre\tToo\n";\n\n$url = 'ftp://username:password@ftp.example.com/remote/path/ftp_test_from_created_file.txt';\n\n// Create a stream context for FTP\n$context = stream_context_create([\n    'ftp' => [\n        'overwrite'   => true,  // Overwrite files with the same name\n        'autorename'  => false, // Do not autorename on conflict\n    ],\n]);\n\n// Write contents directly to the remote file\n$result = file_put_contents($url, $tsv_content, 0, $context);\n\nif ($result !== false) {\n    echo "File was successfully written via FTP.";\n} else {\n    echo "There was an error writing the file: ";\n}\n?>