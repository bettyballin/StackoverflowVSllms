$arr = array('name' => 'aalaap', 'age' => 29, 'location' => 'mumbai');\n\n$result = array();\narray_map(function($key, $value) use (&$result) {\n    $result[] = $key;\n    $result[] = $value;\n}, array_keys($arr), array_values($arr));\n\nprint_r($result);