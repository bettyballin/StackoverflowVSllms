// Assuming Zend_Loader_Autoloader_Resource is used for resource autoloading\n\n$modules = new Modules();\n$activeModules = $modules->fetchActive();\n$defaultModule = ''; // Default module name\n\n$frontController = Zend_Controller_Front::getInstance();\n$moduleDirectory = APPLICATION_PATH . '/modules';\n\nforeach($activeModules as $mod) {\n    // Configure the module directory and default module\n    if ($mod->default) {\n        $defaultModule = $mod->name;\n        $frontController->addModuleDirectory($moduleDirectory);\n        $frontController->setDefaultModule($mod->name);\n        // Set controller directory for the default module without namespace prefix\n        $frontController->setControllerDirectory(array(\n            $mod->name => $moduleDirectory . '/' . $mod->name . '/controllers'\n        ));\n    } else {\n        // Setup resource autoloader with namespace for other modules\n        $resourceLoader = new Zend_Loader_Autoloader_Resource(array(\n            'basePath'  => $moduleDirectory . '/' . $mod->name,\n            'namespace' => ucfirst($mod->name)\n        ));\n        \n        // Register additional resource types if necessary\n        $resourceLoader->addResourceType('model', 'models/', 'Model');\n        \n        // No need to set controllerDir here as ZF handles it via the namespace\n    }\n}\n\n// Set default action controller suffix\nZend_Controller_Front::getInstance()->setParam('defaultControllerSuffix', 'Controller');\n\n// Dispatch the front controller\n$frontController->dispatch();