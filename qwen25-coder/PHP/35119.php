<?php\n\nrequire_once 'dbinterface.php';\nrequire_once 'config.inc.php';\n\nclass user {\n\n    private $db;\n\n    function __construct($id) {\n        global $DB; // Import $DB array from the global scope\n        $this->db = new db($DB['host'], $DB['user'], $DB['pass'], $DB['database']);\n        // ... other initialization code ...\n    }\n}\n\n// Example usage:\nnew user('1');\n?>