use Zend\Session\SessionManager;\n    use Zend\Session\Storage\SessionArrayStorage;\n\n    $sessionManager = new SessionManager();\n    $storage = new SessionArrayStorage();\n    $sessionManager->setStorage($storage);