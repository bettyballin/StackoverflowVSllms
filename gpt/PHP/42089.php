<?php\n// Plugin Interface\ninterface PluginInterface {\n    public function register();\n}\n\n// Core Application Class\nclass Application {\n    protected $plugins = [];\n\n    public function loadPlugins($pluginDir) {\n        foreach (glob("$pluginDir/*.php") as $pluginFile) {\n            require_once $pluginFile;\n            $pluginClass = basename($pluginFile, '.php');\n            if (class_exists($pluginClass) && in_array(PluginInterface::class, class_implements($pluginClass))) {\n                $pluginInstance = new $pluginClass();\n                $pluginInstance->register();\n                $this->plugins[] = $pluginInstance;\n            }\n        }\n    }\n\n    // Event Dispatcher\n    public function dispatchEvent($eventName, $eventData = []) {\n        foreach ($this->plugins as $plugin) {\n            if (method_exists($plugin, $eventName)) {\n                $plugin->$eventName($eventData);\n            }\n        }\n    }\n}\n\n// Example Plugin\nclass ExamplePlugin implements PluginInterface {\n    public function register() {\n        echo "ExamplePlugin registered!\n";\n    }\n\n    public function onUserCreate($eventData) {\n        echo "User created: " . $eventData['username'] . "\n";\n    }\n}\n\n// Usage\n$app = new Application();\n$app->loadPlugins(__DIR__ . '/plugins');\n$app->dispatchEvent('onUserCreate', ['username' => 'john_doe']);