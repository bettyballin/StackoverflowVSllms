$frontController\n    ->setParam('environment', $this->environment)\n    ->setControllerDirectory(ROOT_DIR . '/controllers')\n    ->addModuleDirectory(ROOT_DIR . '/modules');