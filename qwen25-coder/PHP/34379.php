// src/Model/Table/UserTable.php\nnamespace App\Model\Table;\n\nuse Cake\ORM\Table;\n\nclass UserTable extends Table {\n    public function initialize(array $config) {\n        parent::initialize($config);\n        // Explicitly setting the table name in case of conflicts.\n        $this->setTable('users');\n    }\n}