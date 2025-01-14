class MyMDB2 extends MDB2\n{\n    private static $instance;\n\n    public static function getInstance()\n    {\n        if (null === static::$instance) {\n            static::$instance = new static();\n        }\n\n        return static::$instance;\n    }\n\n    protected function __construct()\n    {\n        parent::__construct();\n        $this->setCharset('utf8');\n    }\n\n    public function setCharset($charset)\n    {\n        $this->exec("SET NAMES " . $this->quote($charset, 'text'));\n    }\n\n    public function connect()\n    {\n        parent::connect();\n        $this->setCharset('utf8');\n    }\n}\n\n// Usage\n$db = MyMDB2::getInstance();