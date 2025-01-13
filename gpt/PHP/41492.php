class UserRow extends Zend_Db_Table_Row_Abstract {\n    public function activate() {\n        $this->status = 'active';\n        return $this->save();\n    }\n}\n\nclass UserTable extends Zend_Db_Table_Abstract {\n    protected $_name = 'users';\n    protected $_rowClass = 'UserRow';\n}\n\n// Usage in a controller\n$userTable = new UserTable();\n$user = $userTable->fetchRow($userTable->select()->where('id = ?', 1));\n$user->activate();