class SQLMethods {\n    private $SQLConnection; // Declare $SQLConnection as a class property\n\n    public function __construct($SQLDBAddress, $SQLUserName, $SQLPassword, $SQLDB) { // Add parameters to the constructor for connection details\n        $this->SQLConnection = mysql_connect($SQLDBAddress, $SQLUserName, $SQLPassword);\n\n        if (!$this->SQLConnection) {\n            die('Could not connect: ' . mysql_error());\n        }\n\n        mysql_select_db($SQLDB, $this->SQLConnection);\n    }\n\n    public function ExecuteQuery($Query) {\n        mysql_query($Query, $this->SQLConnection) or die('Could not perform query: ' . mysql_error()); // Use the class property\n    }\n}