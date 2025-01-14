class TableA extends Zend_Db_Table_Abstract\n{\n    protected $_schema          = 'schema1';\n    protected $_name            = 'tablea';\n\n    public function findDependentRowset($dependentTable, $ruleKey = null, $queryType = self::SELECT)\n    {\n        $dependentTable = $this->_getTableFromString($dependentTable);\n        $select = $dependentTable->select();\n        \n        // Set the schema explicitly if it's not already set\n        if (!$select->getPart(Zend_Db_Select::FROM)[0]->schema) {\n            $select->from(['t' => ['schema' => $dependentTable->_schema, 'name' => $dependentTable->_name]]);\n        }\n        \n        return parent::findDependentRowset($dependentTable, $ruleKey, $queryType);\n    }\n}\n\nclass TableB extends Zend_Db_Table_Abstract\n{\n    protected $_schema          = 'schema2';\n    protected $_name            = 'tableb';\n\n    public function findDependentRowset($dependentTable, $ruleKey = null, $queryType = self::SELECT)\n    {\n        $dependentTable = $this->_getTableFromString($dependentTable);\n        $select = $dependentTable->select();\n        \n        // Set the schema explicitly if it's not already set\n        if (!$select->getPart(Zend_Db_Select::FROM)[0]->schema) {\n            $select->from(['t' => ['schema' => $dependentTable->_schema, 'name' => $dependentTable->_name]]);\n        }\n        \n        return parent::findDependentRowset($dependentTable, $ruleKey, $queryType);\n    }\n}