class Application_Model_DbTable_Actions extends Zend_Db_Table_Abstract {\n    protected $_name = 'actions';\n    protected $_dependentTables = array('Application_Model_DbTable_Users');\n\n    public function fetchAllActionsWithUserDetails() {\n        $select = $this->select()\n            ->setIntegrityCheck(false) // Important for joining tables not linked via relationships\n            ->from(array('a' => 'actions'))\n            ->joinLeft(array('u' => 'users'), 'a.user_id = u.id',\n                array(\n                    'user_name' => 'u.name', // Select required user fields\n                    'user_email' => 'u.email'\n                )\n            );\n        return $this->fetchAll($select);\n    }\n}