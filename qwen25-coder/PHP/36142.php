protected function _initAutoload()\n{\n    $autoloader = Zend_Loader_Autoloader::getInstance();\n    $autoloader->registerNamespace('Sl_');\n    return $autoloader;\n}