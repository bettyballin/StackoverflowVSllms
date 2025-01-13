// Sample code for Zend Queue\n$queue = new Zend_Queue('Array');  // Or use a persistent backend like Redis\n\n// Create a new message\n$message = 'Task data or identifier';\n\n// Send the message to the queue\n$queue->send($message);\n\n// Worker script to process the queue\nwhile ($message = $queue->receive()) {\n    // Process the message\n    processTask($message->body);\n    $queue->deleteMessage($message);\n}\n\nfunction processTask($taskData) {\n    // Task processing logic goes here\n}