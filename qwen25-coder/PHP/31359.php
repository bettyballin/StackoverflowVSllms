$pluginConfig = [\n    'name' => 'ExamplePlugin',\n    'version' => '1.0.0',\n    'enabled' => true,\n];\n\n\CRM\Plugins\PluginManager::register(\CRM\Plugins\ExamplePlugin, $pluginConfig);