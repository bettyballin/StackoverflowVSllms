<?php\nclass ClassA {\n    public function doSomething() {\n        // Your code here\n        sleep(1); // Example delay\n    }\n}\n\nclass ClassB {\n    public function doSomething() {\n        // Your code here\n        sleep(2); // Example delay\n    }\n}\n\n$classes = ['ClassA', 'ClassB'];\n\nforeach ($classes as $class) {\n    $object = new $class();\n    $start_time = microtime(true);\n    $object->doSomething();\n    $end_time = microtime(true);\n    $execution_time = $end_time - $start_time;\n\n    echo "Execution Time for $class: " . $execution_time . " seconds\n";\n}\n?>