// In your application bootstrap or index file\nset_include_path(get_include_path() . PATH_SEPARATOR . '/path/to/application/library');\nrequire_once 'Zend/Loader/Autoloader.php';\n$autoloader = Zend_Loader_Autoloader::getInstance();\n$autoloader->registerNamespace('Core_');