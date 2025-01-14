class AbstractPlatform {\n    public function getSelectSQL() { /* ... */ }\n    // Other methods for different SQL types\n}\n\nclass MySQLPlatform extends AbstractPlatform {\n    public function getSelectSQL($fields, $where) {\n        return "SELECT ".implode(", ", $fields)." WHERE ".$where;\n    }\n}