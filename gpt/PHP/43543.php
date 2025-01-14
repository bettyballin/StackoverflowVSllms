<?php\nclass SQLMethods {\n    private $SQLConnection;\n\n    public function __construct($SQLDBAddress, $SQLUserName, $SQLPassword, $SQLDB) {\n        $this->SQLConnection = new mysqli($SQLDBAddress, $SQLUserName, $SQLPassword, $SQLDB);\n\n        if ($this->SQLConnection->connect_error) {\n            die('Connect Error (' . $this->SQLConnection->connect_errno . ') ' . $this->SQLConnection->connect_error);\n        }\n    }\n\n    public function ExecuteQuery($Query) {\n        $result = $this->SQLConnection->query($Query);\n        \n        if (!$result) {\n            die('Query Error: ' . $this->SQLConnection->error);\n        }\n\n        return $result;\n    }\n\n    public function __destruct() {\n        $this->SQLConnection->close();\n    }\n}\n\n// Example usage\n$database = new SQLMethods('localhost', 'username', 'password', 'database');\n$result = $database->ExecuteQuery('SELECT * FROM table_name');