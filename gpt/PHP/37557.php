amespace Application;\n\nuse Zend\Mvc\MvcEvent;\nuse Zend\View\Renderer\PhpRenderer;\n\nclass Module\n{\n    public function onBootstrap(MvcEvent $e)\n    {\n        $application = $e->getApplication();\n        $serviceManager = $application->getServiceManager();\n        $viewRenderer = $serviceManager->get('ViewRenderer');\n        \n        // Add custom partials directory\n        $viewRenderer->resolver()->addPath(__DIR__ . '/../views/scripts/partials');\n    }\n}