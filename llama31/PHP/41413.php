class Custom_Db_Adapter extends Zend_Db_Adapter_Mysqli\n{\n    public function getSchema($tableName)\n    {\n        $table = $this->getTable($tableName);\n        if ($table instanceof Zend_Db_Table_Abstract) {\n            return $table->_getSchema();\n        }\n        return parent::getSchema($tableName);\n    }\n}