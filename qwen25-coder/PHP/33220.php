// Enable view caching\n   Zend_Registry::set('Zend_View', new Zend_View(array(\n       'scriptPath' => APPLICATION_PATH . '/views/scripts/',\n       'strictVars' => true,\n   )));\n\n   $view = Zend_Registry::get('Zend_View');\n   $frontController->setParam('noViewRenderer', true);\n   $cache = Zend_Cache::factory(\n       'Output',\n       'File',\n       array('lifetime'=> 7200, 'automatic_serialization' => true),\n       array('cache_dir' => './tmp/')\n   );\n\n   $view->getBroker()->setCache($cache);\n\n   // To use caching for a specific view script\n   $view->partial(true, 'your_script.phtml');