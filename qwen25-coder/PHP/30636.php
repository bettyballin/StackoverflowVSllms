<?php\nclass DatabaseHandler {\n    private $con;\n\n    public function __construct() {\n        $this->con = connectToDatabase(); // Initialize your database connection here\n    }\n\n    public function doSomething() {\n        // Do stuff with MySQL\n        $this->con->tralalala();\n    }\n}\n\n$dbHandler = new DatabaseHandler();\n$dbHandler->doSomething();\n?>