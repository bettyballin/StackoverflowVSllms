class Model_name extends CI_Model {\n    public $param_var;\n\n    public function __construct() {\n        parent::__construct();\n    }\n\n    public function set_param($param_var) {\n        $this->param_var = $param_var;\n    }\n}