// Model\nclass Default_Model_Guestbook\n{\n    protected $_comment;\n    protected $_created;\n    protected $_poster;\n    // list continues with all columns\n}\n\n// DbTable\nclass Default_Model_DbTable_Guestbook extends Zend_Db_Table_Abstract\n{\n    protected $_name = 'guestbook';\n}\n\n// Mapper\nclass Default_Model_GuestbookMapper\n{\n    public function save(Default_Model_Guestbook $model)\n    {\n        // Save logic here\n    }\n\n    public function find($id, Default_Model_Guestbook $model)\n    {\n        // Find logic here\n    }\n\n    public function fetchAll()\n    {\n        // Fetch all logic here\n    }\n}