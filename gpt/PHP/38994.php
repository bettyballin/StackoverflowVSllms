Zend_Session::start();\nif (Zend_Auth::getInstance()->hasIdentity()) {\n    Zend_Session::regenerateId();\n    Zend_Session::writeClose();\n}