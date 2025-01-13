class Config {\n    private $settings;\n\n    public function __construct($file) {\n        $this->settings = parse_ini_file($file, true);\n    }\n\n    public function get($key) {\n        return $this->settings[$key];\n    }\n}\n\n$config = new Config('my_config.php');\n$setting = $config->get('setting_name');