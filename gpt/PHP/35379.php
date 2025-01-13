class Person {\n       public function __call($name, $arguments) {\n           echo "Calling method '$name' with arguments: " . implode(', ', $arguments) . "\n";\n       }\n   }\n\n   $person = new Person();\n   $person->sayHello("John");  // Outputs: Calling method 'sayHello' with arguments: Joh