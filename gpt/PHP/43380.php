// src/Model/Table/BooksTable.php\n   namespace App\Model\Table;\n\n   use Cake\ORM\Table;\n\n   class BooksTable extends Table\n   {\n       public function initialize(array $config): void\n       {\n           parent::initialize($config);\n\n           $this->setTable('books');\n           $this->setPrimaryKey('id');\n       }\n   }