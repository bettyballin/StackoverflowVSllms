<?php\nif (isset($_REQUEST['message'])) {\n    $message = $_REQUEST['message'];\n    // Process the message and return a JSON response\n    echo json_encode(array('success' => true, 'message' => $message));\n} else {\n    echo json_encode(array('success' => false, 'message' => 'No message received.'));\n}\n?>