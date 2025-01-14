<?php // example-plugin/ExamplePlugin.php\nclass ExamplePlugin {\n    public function __construct(HookHandler $hookHandler) {\n        $hookHandler->addHook('example_hook', [$this, 'pluginFunction']);\n    }\n\n    public function pluginFunction($data) {\n        echo "Plugin function is called with data: " . $data;\n    }\n}