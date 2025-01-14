use Cake\ORM\TableRegistry;\nuse Cake\Datasource\Paginator;\n\n$model = TableRegistry::getTableLocator()->get('YourModelName');\n$paginator = new Paginator();\n\n$query = $model->find('all');\n$results = $paginator->paginate($query, [\n    'limit' => 20, // Number of rows per page\n    'page' => 1 // Current page number\n]);\n\nforeach ($results as $row) {\n    // Process each row here\n    print_r($row);\n}