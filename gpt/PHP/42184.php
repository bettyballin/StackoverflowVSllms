// Domain object representing a single person\nclass Model_Row_Person\n{\n    protected $_gateway;\n\n    public function __construct(Zend_Db_Table_Row $gateway)\n    {\n        $this->_gateway = $gateway;\n    }\n\n    public function login($userName, $password)\n    {\n        // Implement login logic\n    }\n\n    public function setPassword($password)\n    {\n        // Implement password setting logic\n    }\n}\n\n// Domain object representing the table of persons\nclass Model_Table_Person implements SeekableIterator, Countable, ArrayAccess\n{\n    protected $_gateway;\n    protected $_pointer = 0;\n    protected $_rows = [];\n\n    public function __construct(Model_DbTable_Person $gateway)\n    {\n        $this->_gateway = $gateway;\n        $this->_rows = $this->_gateway->fetchAll();\n    }\n\n    public function current()\n    {\n        $current = $this->_rows[$this->_pointer];\n        return $this->_getUser($current);\n    }\n\n    private function _getUser(Zend_Db_Table_Row $current)\n    {\n        switch ($current->userType) {\n            case 'admin':\n                return new Model_Row_Administrator($current);\n            case 'associate':\n                return new Model_Row_Associate($current);\n            default:\n                return new Model_Row_Person($current);\n        }\n    }\n\n    public function seek($position)\n    {\n        $this->_pointer = $position;\n    }\n\n    public function next()\n    {\n        ++$this->_pointer;\n    }\n\n    public function key()\n    {\n        return $this->_pointer;\n    }\n\n    public function valid()\n    {\n        return isset($this->_rows[$this->_pointer]);\n    }\n\n    public function rewind()\n    {\n        $this->_pointer = 0;\n    }\n\n    public function count()\n    {\n        return count($this->_rows);\n    }\n\n    public function offsetExists($offset)\n    {\n        return isset($this->_rows[$offset]);\n    }\n\n    public function offsetGet($offset)\n    {\n        return $this->_getUser($this->_rows[$offset]);\n    }\n\n    public function offsetSet($offset, $value)\n    {\n        throw new Exception("Read-only access");\n    }\n\n    public function offsetUnset($offset)\n    {\n        throw new Exception("Read-only access");\n    }\n}