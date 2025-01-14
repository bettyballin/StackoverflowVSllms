// Include Medoo\nrequire 'path/to/Medoo/autoload.php';\n\nuse Medoo\Medoo;\n\n// Initialize\n$database = new Medoo([\n    'type' => 'mysql',\n    'host' => '127.0.0.1',\n    'database' => 'name_of_database',\n    'username' => 'username',\n    'password' => 'password'\n]);\n\n// Fetch data (internally uses prepared statements)\n$data = $database->select('your_table', [\n    "column1",\n    "column2"\n], [\n    // where conditions here\n]);\n\nforeach ($data as $row) {\n    echo $row['column1'] . ' - ' . $row['column2'];\n}