class My_Db_Adapter_Mysqli extends Zend_Db_Adapter_Mysqli\n{\n    public function unbufferedQuery($sql)\n    {\n        $result = parent::_query($sql, null, MYSQLI_USE_RESULT);\n        return new My_Db_Statement_Unbuffered($result, $this->_fetchMode);\n    }\n}\n\nclass My_Db_Statement_Unbuffered extends Zend_Db_Statement_Mysqli\n{\n    public function fetchAll()\n    {\n        $data = [];\n        while ($row = $this->fetch()) {\n            $data[] = $row;\n        }\n        return $data; // For testing, normally you would iterate without collecting all rows\n    }\n\n    public function fetchAllLazy() {\n        // Generator to yield row by row\n        while (($row = $this->_stmt->fetch_assoc()) !== null) {\n            yield $row;\n        }\n    }\n}