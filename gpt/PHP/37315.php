use Cake\Datasource\ConnectionManager;\n\n$connection = ConnectionManager::get('default');\n$logger = $connection->getLogger();\n$logger->enabled(true);\n\n// Your query or code here\n\n// Disable logging after your code\n$logger->enabled(false);