class Main {\n  public $vars = array();\n}\n\n$main = new Main;\n$main->vars['key'] = 'value';\n\nclass Extended extends Main {\n  public function __construct() {\n    parent::__construct(); // call parent constructor\n  }\n}\n\n$other = new Extended;\nvar_dump($other->vars); // output: array(0) { }