spl_autoload_register(function ($class) {\n    $prefix = 'Plugin\\';\n    $base_dir = __DIR__ . '/plugins/';\n\n    if (0 === strpos($class, $prefix)) {\n        $relative_class = substr($class, strlen($prefix));\n        $file = $base_dir . str_replace('\\', '/', $relative_class) . '.php';\n\n        if (file_exists($file)) {\n            require $file;\n        }\n    }\n});\n\ninterface PluginInterface {\n    public function process();\n}\n\nabstract class Plugin {\n    protected $db;\n\n    public function setDb($db) {\n        $this->db = $db;\n    }\n}\n\nfunction processPlugin($pluginNamespace, $db) {\n    $plgin = new $pluginNamespace();\n    $plgin->setDb($db);\n    return $plgin->process();\n}