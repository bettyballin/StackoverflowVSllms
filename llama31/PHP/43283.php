$arr1 = array('foo' => 'bar');\n$arr2 = $arr1; // creates a copy of $arr1\n$arr2['foo'] = 'baz'; // does not affect $arr1\n\n$arr3 = &$arr1; // creates a reference to $arr1\n$arr3['foo'] = 'baz'; // affects $arr1