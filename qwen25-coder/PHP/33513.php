use Cake\Log\Engine\FileLog;\nuse Cake\Log\Log;\n\n// Setup a new Logger for SQL queries\nLog::config('sqlQueries', [\n    'engine' => FileLog::class,\n    'file' => 'sql_queries',\n    'scopes' => ['queriesLog'],\n]);\n\n// Enable query logging with the custom logger\nConnectionManager::config('default', function ($conn) {\n    $conn->log(true, 'queriesLog');\n});