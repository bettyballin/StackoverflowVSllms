$a = array('b' => null);\nvar_dump(array_key_exists('b', $a)); // outputs: bool(true)\nvar_dump(array_key_exists('c', $a)); // outputs: bool(false)\n\nclass Test {\n    public $b = null;\n}\n\n$obj = new Test();\nvar_dump(property_exists($obj, 'b')); // outputs: bool(true)\nvar_dump(property_exists($obj, 'c')); // outputs: bool(false)