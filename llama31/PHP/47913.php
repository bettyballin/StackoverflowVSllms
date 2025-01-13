// Base_Controller.php\nclass Base_Controller extends Controller {\n    protected $db;\n    protected $session;\n\n    public function __construct() {\n        parent::__construct();\n        $this->db = Database::instance('default'); // assuming 'default' is your database group\n        $this->session = Session::instance();\n    }\n}\n\n// MyController.php\nclass MyController extends Base_Controller {\n    public function action_index() {\n        $var = $this->session->get('var');\n        $query = $this->db->query('SELECT * FROM `table`');\n        // ...\n    }\n}