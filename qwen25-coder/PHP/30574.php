class MyClass {\n    public function func1() {\n        $test = array(1, 2, 3);\n        return $test;\n    }\n\n    public function func2() {\n        $newarray = $this->func1(); // Call func1 and get the returned array\n        print_r($newarray);       // Print the array\n    }\n}\n\n$obj = new MyClass();\n$obj->func2();  // This will output: Array ( [0] => 1 [1] => 2 [2] => 3 )