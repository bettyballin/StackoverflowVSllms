<?php\nclass Foo {\n    protected $test = 1;\n    public function bar($a, $b) {\n        echo 'hi' . $this->test;\n        return strcmp($a, $b);\n    }\n}\n\n\n$topics = array(1,2,3);\n$foo = new Foo;\nusort($topics, array($foo, 'bar'));