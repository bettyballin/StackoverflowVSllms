class MyClass {\n    public static function compare_label($a, $b) {\n        return strnatcmp($a['label'], $b['label']);\n    }\n\n    public function sortLabel() {\n        usort($label, array('MyClass', 'compare_label'));\n    }\n}