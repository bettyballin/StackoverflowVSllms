$allowedClasses = array ("MyClass1", "MyClass2");\n$allowedMethods = array ('publicMethod1', 'publicMethod2'); // Define allowed methods\n\nif (!in_array ($_GET['class'], $allowedClasses))\n    throw new Exception ("Class not found!");\n\n// Create an instance of the class\n$obj = new $_GET['class'];\n\nif (!in_array ($_GET['method'], $allowedMethods) || !method_exists ($obj, $_GET['method']))\n    throw new Exception ("Method not found!");\n\n// Call the method securely\necho $obj->{$_GET['method']}();