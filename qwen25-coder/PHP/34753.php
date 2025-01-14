<?php\n\nclass PluginManager {\n    private $hooks = [];\n\n    public function addAction($hook, $callback) {\n        if (!isset($this->hooks[$hook])) {\n            $this->hooks[$hook] = [];\n        }\n        $this->hooks[$hook][] = $callback;\n    }\n\n    public function doAction($hook) {\n        if (isset($this->hooks[$hook])) {\n            foreach ($this->hooks[$hook] as $callback) {\n                call_user_func_array($callback, array_slice(func_get_args(), 1));\n            }\n        }\n    }\n}\n\n// Example usage\n$pluginManager = new PluginManager();\n\n// Add a plugin function to an action hook\n$pluginManager->addAction('user_register', function($userId) {\n    echo "User with ID $userId has been registered.";\n});\n\nfunction register_user($email, $password) {\n    // Simulate user registration\n    $userId = rand(1000, 2000); // Example user ID\n\n    // Trigger the 'user_register' action hook after registration\n    global $pluginManager;\n    $pluginManager->doAction('user_register', $userId);\n\n    return $userId;\n}\n\n// Register a new user and trigger plugins\nregister_user('example@example.com', 'securepassword');\n?>