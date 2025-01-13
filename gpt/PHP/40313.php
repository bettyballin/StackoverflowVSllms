<?php\nclass Test {\n    public $a;\n    private $b;\n\n    private function setB($val) {\n        if (!is_numeric($val)) {\n            throw new Exception("Variable \$b must be numeric");\n        }\n        echo ("__SET: Setting b to {$val}<br/>");\n        $this->b = $val;\n    }\n\n    function __set($key, $val) {\n        switch ($key) {\n            case 'b':\n                $this->setB($val);\n                break;\n            default:\n                $this->$key = $val;\n        }\n    }\n\n    function __get($key) {\n        return $this->$key;\n    }\n\n    function bMethod() {\n        $this->setB("World2");\n    }\n}\n\n$t = new Test();\n\n// testing a\ntry {\n    $t->a = "hello";\n    echo "PASS: Testing a: {$t->a}<br/>";\n} catch (Exception $e) {\n    echo "FAIL: Testing a";\n}\n\n// testing b\ntry {\n    $t->b = "world";\n    echo "FAIL: Testing b exception handling<br/>";\n} catch (Exception $e) {\n    echo "PASS: Testing b exception handling<br/>";\n}\n\n// testing b with valid value\ntry {\n    $t->b = 123;\n    echo "PASS: Testing b with valid value: {$t->b}<br/>";\n} catch (Exception $e) {\n    echo "FAIL: Testing b";\n}\n\n// bypassing exception handling with method\ntry {\n    $t->bMethod();\n    echo "FAIL: Testing b exception handling {$t->b}<br/>";\n} catch (Exception $e) {\n    echo "PASS: Testing b exception handling<br/>";\n}\n?>