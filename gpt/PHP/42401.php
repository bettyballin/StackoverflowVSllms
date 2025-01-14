<?php\n\nclass AsyncProcessor {\n    private $callback;\n\n    public function __construct(callable $callback) {\n        $this->callback = $callback;\n    }\n\n    public function doAsyncTask() {\n        // Simulate an asynchronous task\n        sleep(2); // Simulates a resource-intensive operation\n        $response = "Task completed";\n\n        // Invoke the callback with the response\n        call_user_func($this->callback, $response);\n    }\n}\n\nclass MyClass {\n    public function myCallbackFunction($response) {\n        echo "Callback received: $response\n";\n    }\n}\n\n// Example usage\n$instance = new MyClass();\n$processor = new AsyncProcessor([$instance, 'myCallbackFunction']);\n$processor->doAsyncTask();\n\n?>