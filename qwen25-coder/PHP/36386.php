<?php\nnamespace Vendor\Project;\n\nclass Calculator {\n    public function add($a, $b) {\n        return $a + $b;\n    }\n}\n\n$calc = new \Vendor\Project\Calculator();\necho $calc->add(5, 3);