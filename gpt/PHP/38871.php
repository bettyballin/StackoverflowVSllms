// Base Controller code\nclass Controller_Base extends Controller {\n\n    protected $db;\n    protected $session;\n\n    public function before() {\n        parent::before();\n        // Instantiate the database and session\n        $this->db = Database::instance('default'); // Replace 'default' with your DB group name if different\n        $this->session = Session::instance();\n    }\n}\n\n// Any other controller that extends Base Controller\nclass Controller_Example extends Controller_Base {\n\n    public function action_index() {\n        // Access session data\n        $var = $this->session->get('var');\n        \n        // Execute a query\n        $query = $this->db->query(Database::SELECT, 'SELECT * FROM `table`');\n        \n        // Do something with the data\n        foreach ($query as $row) {\n            // Process each row\n            echo $row['column_name'];\n        }\n    }\n}