// Enable error reporting and display of errors\nerror_reporting(E_ALL);\nini_set('display_errors', 1);\n\nZend_Application::setPhpSettings(array(\n    'date.timezone' => 'America/New_York', // Set your timezone if required\n));\n\n// Create application, bootstrap, and run\n$application = new Zend_Application(\n    APPLICATION_ENV,\n    APPLICATION_PATH . '/configs/application.ini'\n);\n$application->bootstrap()\n            ->run();