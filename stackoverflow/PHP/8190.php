<?php\nclass Config {\n    protected $_vars = array();\n\n    protected static $_instance;\n\n    private function __construct() {}\n\n    public static function getInstance()\n    {\n        if (!isset(self::$_instance)) {\n            self::$_instance = new self();\n        }\n        return self::$_instance;\n    }\n\n    public function &__get($name) {\n        return $this->_vars[$name];\n    }\n\n    public function __set ($name, $value) {\n        $this->_vars[$name] = $value;\n    }\n}\n\n$config = Config::getInstance();\n$config->db = array('localhost', 'root', '');\n$config->templates = array(\n    'main' => 'main',\n    'news' => 'news_list'\n);\n\nclass DB {\n    public $db;\n\n    public function __construct($db)\n    {\n        $this->db = $db;\n    }\n\n    public function connect()\n    {\n        mysql_connect($this->db[0], $this->db[1], $this->db[2]);\n    }\n}\n\n$config = Config::getInstance();\n$db = new DB($config->db);\n$db->connect();\n\nclass Templates {\n    public $templates;\n\n    public function __construct($templates)\n    {\n        $this->templates = $templates;\n    }\n\n    public function load ($where) {\n        return $this->templates[$where];\n    }\n}\n\n$config = Config::getInstance();\n$templates = new Templates($config->templates);\necho $templates->load('main') . "\n";