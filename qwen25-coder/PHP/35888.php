class BusinessLogic {\n    public function calculateSum($a, $b) {\n        return $a + $b;\n    }\n\n    public function isEven($number) {\n        if ($number % 2 == 0) {\n            return true;\n        } else {\n            return false;\n        }\n    }\n}