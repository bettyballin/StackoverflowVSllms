// In uri-resolve.php\nclass URIResolve {\n    private $tablePages;\n    public $category = null;\n\n    public function __construct($tablePages) {\n        $this->tablePages = $tablePages;\n    }\n\n    public function process_uri() {\n        $this->category = $this->tablePages;\n    }\n}\n\n// In settings.php\nrequire_once(ABSPATH.INC.FUNC.'/table-config.php');\nrequire_once(ABSPATH.INC.CLASS.'/uri-resolve.php');\n\n$uriResolve = new URIResolve($tablePages);\n$uriResolve->process_uri();