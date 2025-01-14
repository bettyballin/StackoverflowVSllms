class TaskHandler {\n       private function __construct() {\n           // Private constructor\n       }\n\n       public static function createAndExecuteTask() {\n           $handler = new self();\n           $handler->executeTask();\n           return $handler; /// If needed to return object for further use\n       }\n\n       private function executeTask() {\n           // Code to perform the task\n       }\n   }\n\n   // Usage\n   TaskHandler::createAndExecuteTask();