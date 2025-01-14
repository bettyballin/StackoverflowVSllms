class Column {\n    private $type;\n    private $dataType;\n    private $nullify;\n    private $default;\n    private $increment;\n    private $unique;\n    private $primary;\n    private $comment;\n\n    public function __construct($config) {\n        // Assigning values to properties from the config array\n        $this->type = $config['data-type']['type'];\n        $this->dataType = $config['data-type'];\n        $this->nullify = $config['nullify'];\n        $this->default = $config['default'] !== null ? var_export($config['default'], true) : 'NULL';\n        $this->increment = $config['increment'];\n        $this->unique = $config['unique'];\n        $this->primary = $config['primary'];\n        $this->comment = $config['comment'];\n    }\n\n    public function toSql() {\n        // Start with the column name and data type\n        $sql = "`value`"; // Assume 'value' is the column name or it can be a parameter.\n        if ($this->dataType['type'] === 'varchar') {\n            $sql .= " VARCHAR(" . intval($this->dataType['length']) . ")";\n            if (isset($this->dataType['character-set'])) {\n                $sql .= " CHARACTER SET {$this->dataType['character-set']}";\n            }\n            if (isset($this->dataType['collate'])) {\n                $sql .= " COLLATE {$this->dataType['collate']}";\n            }\n        }\n\n        // Adding constraints\n        if (!$this->nullify) {\n            $sql .= " NOT NULL";\n        } else {\n            $sql .= " NULL";\n        }\n\n        if ($this->default !== null) {\n            $sql .= " DEFAULT {$this->default}";\n        }\n\n        if ($this->increment) {\n            $sql .= " AUTO_INCREMENT";\n        }\n\n        if ($this->unique) {\n            $sql .= " UNIQUE";\n        }\n\n        if ($this->primary) {\n            $sql .= " PRIMARY KEY";\n        }\n\n        // Adding comment\n        if (!empty($this->comment)) {\n            $sql .= ' COMMENT ' . var_export($this->comment, true);\n        }\n\n        return $sql;\n    }\n}\n\n// Example usage:\n$yamlConfig = [\n    'type' => 'character',\n    'data-type' => [\n        'type' => 'varchar',\n        'length' => 255,\n        // ... other properties\n    ],\n    'nullify' => true,\n    'default' => null,\n    'increment' => false,\n    'unique' => false,\n    'primary' => false,\n    'comment' => "This is a small general text field.",\n];\n\n$column = new Column($yamlConfig);\necho $column->toSql();