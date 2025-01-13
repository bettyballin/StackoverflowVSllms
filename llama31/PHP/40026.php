class Chester {\n    public $db;\n    public $sql;\n\n    public function __construct() {\n        $this->db = new DB($this);\n        $this->sql = new SQL();\n    }\n}\n\nclass DB {\n    private $chester;\n\n    public function __construct(Chester $chester) {\n        $this->chester = $chester;\n    }\n\n    public function query() {\n        // You can access Chester and its properties here\n        $this->chester->sql->execute();\n    }\n}\n\nclass SQL {\n    public function execute() {\n        // SQL execution code here\n    }\n}