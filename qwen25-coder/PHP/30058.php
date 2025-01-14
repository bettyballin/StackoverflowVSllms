class My_Db_Table_Abstract extends Zend_Db_Table_Abstract {\n    public function __call($method, $args) {\n        if (substr($method, 0, 8) === 'findBy') {\n            $fieldName = lcfirst(substr($method, 8));\n            if (count($args) !== 1) {\n                throw new Exception("Method {$method} expects exactly one argument");\n            }\n            $select = $this->select()->where("{$fieldName} = ?", $args[0]);\n            return $this->fetchRow($select);\n        }\n        return parent::__call($method, $args);\n    }\n}