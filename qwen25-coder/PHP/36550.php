class DatabaseWebservice {\n    public function enqueueInsert($sql) {\n        enqueueTransaction($sql);\n        return "Transaction queued.";\n    }\n\n    public function commitAllTransactions() {\n        commitTransactions();\n        return "All transactions committed successfully.";\n    }\n\n    public function rollbackAllTransactions() {\n        rollbackTransactions();\n        return "All transactions rolled back successfully.";\n    }\n}\n\n$options = [\n    'uri' => 'http://example.com/database',\n];\n\n$server = new SoapServer(null, $options);\n$server->setClass('DatabaseWebservice');\n$server->handle();