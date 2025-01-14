<?php\n\nrequire 'vendor/autoload.php'; // Ensure you have symfony/yaml installed via Composer\n\nuse Symfony\Component\Yaml\Yaml;\n\nclass ColumnGenerator\n{\n    public function generateColumnSQL($yamlString)\n    {\n        $config = Yaml::parse($yamlString);\n        $columnConfig = $config[0]; // Assuming single column config for simplicity\n\n        $sqlParts = [];\n        $sqlParts[] = $this->generateDataTypeSQL($columnConfig['data-type']);\n        $sqlParts[] = $columnConfig['nullify'] ? 'NULL' : 'NOT NULL';\n        \n        if (isset($columnConfig['default'])) {\n            $sqlParts[] = 'DEFAULT ' . $this->quoteValue($columnConfig['default']);\n        }\n        \n        if ($columnConfig['unique']) {\n            $sqlParts[] = 'UNIQUE';\n        }\n        \n        if ($columnConfig['primary']) {\n            $sqlParts[] = 'PRIMARY KEY';\n        }\n        \n        if (!empty($columnConfig['comment'])) {\n            $sqlParts[] = 'COMMENT ' . $this->quoteValue($columnConfig['comment']);\n        }\n\n        return implode(' ', array_filter($sqlParts));\n    }\n\n    private function generateDataTypeSQL($dataTypeConfig)\n    {\n        $sql = strtoupper($dataTypeConfig['type']);\n        if (!empty($dataTypeConfig['length'])) {\n            $sql .= "({$dataTypeConfig['length']})";\n        }\n        \n        if (!empty($dataTypeConfig['collate'])) {\n            $sql .= " COLLATE {$dataTypeConfig['collate']}";\n        }\n        \n        if (!empty($dataTypeConfig['character-set'])) {\n            $sql .= " CHARACTER SET {$dataTypeConfig['character-set']}";\n        }\n        \n        if ($dataTypeConfig['binary']) {\n            $sql .= " BINARY";\n        }\n\n        return $sql;\n    }\n\n    private function quoteValue($value)\n    {\n        if (is_null($value)) {\n            return 'NULL';\n        }\n        return "'" . addslashes($value) . "'";\n    }\n}\n\n// Example usage\n$yamlString = <<<YAML\n- type: character\n  data-type:\n    type: varchar\n    length: 255\n    decimals: null\n    unsigned: null\n    zerofill: null\n    collate: utf8_unicode_ci\n    character-set: utf8\n    binary: false\n    spatial-type: null\n    values: null\n  nullify: true\n  default: null\n  increment: false\n  unique: false\n  primary: false\n  comment: This is a small general text field.\n  format: default\n  storage: default\nYAML;\n\n$generator = new ColumnGenerator();\n$sql = $generator->generateColumnSQL($yamlString);\necho $sql;\n?>