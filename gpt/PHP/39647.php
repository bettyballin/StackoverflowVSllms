amespace YourModule;\n\nuse Zend\Db\Adapter\AdapterInterface;\nuse Zend\Session\Config\SessionConfig;\nuse Zend\Session\Container;\nuse Zend\Session\SessionManager;\nuse Zend\Session\SaveHandler\DbTableGateway as DbTableGatewaySaveHandler;\nuse Zend\Session\Storage\DbTableGateway as DbTableGatewayStorage;\nuse Zend\Session\Validator\RemoteAddr;\nuse Zend\Session\Validator\HttpUserAgent;\n\nclass Module\n{\n    public function onBootstrap(\Zend\Mvc\MvcEvent $e)\n    {\n        $application = $e->getApplication();\n        $serviceManager = $application->getServiceManager();\n        $config = $serviceManager->get('config');\n        \n        $sessionConfig = new SessionConfig();\n        $sessionConfig->setOptions($config['session_config']);\n\n        $sessionManager = new SessionManager($sessionConfig);\n        $container = new Container('initialized');\n        if (!isset($container->init)) {\n            $sessionManager->start();\n            $container->init = 1;\n        }\n        \n        $sessionManager->getValidatorChain()->attach('session.validate', array(new RemoteAddr(), 'isValid'));\n        $sessionManager->getValidatorChain()->attach('session.validate', array(new HttpUserAgent(), 'isValid'));\n\n        $adapter = $serviceManager->get(AdapterInterface::class);\n        $saveHandler = new DbTableGatewaySaveHandler($adapter, $config['session_save_handler']['options']);\n        $sessionManager->setSaveHandler($saveHandler);\n\n        Container::setDefaultManager($sessionManager);\n    }\n}