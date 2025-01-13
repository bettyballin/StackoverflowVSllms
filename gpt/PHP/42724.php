function loadPlugins($pluginDir) {\n    foreach (glob($pluginDir . '/*.php') as $filename) {\n        include_once $filename;\n    }\n}\n\n// Example of registering a plugin\nclass ExamplePlugin {\n    public function __construct() {\n        EventManager::listen('onUserLogin', [$this, 'handleUserLogin']);\n    }\n\n    public function handleUserLogin($user) {\n        // Plugin logic for user login\n    }\n}\n\n// Load plugins\nloadPlugins(__DIR__ . '/plugins');