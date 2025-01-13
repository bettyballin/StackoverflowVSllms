class Main {\n  public $vars = array();\n}\n\n$main = new Main;\n$main->vars['key'] = 'value';\n\nclass Extended {\n  private $main;\n\n  public function __construct(Main $main) {\n    $this->main = $main;\n  }\n\n  public function getVars() {\n    return $this->main->vars;\n  }\n}\n\n$other = new Extended($main);\nvar_dump($other->getVars()); // output: array(1) { ["key"]=> string(5) "value" }