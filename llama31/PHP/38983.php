// customer1/init.php\nfunction customer1_autoloader($className) {\n    include dirname(__FILE__) . "/classes/" . $className . ".php";\n}\nspl_autoload_register('customer1_autoloader');\n\n// customer2/init.php\nfunction customer2_autoloader($className) {\n    include dirname(__FILE__) . "/classes/" . $className . ".php";\n}\nspl_autoload_register('customer2_autoloader');