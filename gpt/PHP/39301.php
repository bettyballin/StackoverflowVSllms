<?php\n// Start output buffering\nob_start();\n\n// Your PHP logic here\n$data = array('success' => true, 'message' => 'Data processed successfully.');\n\n// Encode the response as JSON\n$response = json_encode($data);\n\n// Clear the buffer and output the response\nob_end_clean();\necho $response;\n?>