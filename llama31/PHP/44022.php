$array = array('foo' => 'bar', 'baz' => 'qux');\n\nforeach ($array as $key => $value) {\n    $$key = $value;\n}\n\necho $foo; // outputs "bar"\necho $baz; // outputs "qux"