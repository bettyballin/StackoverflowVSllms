// StranglerController.php\nclass StranglerController extends Zend_Controller_Action\n{\n    public function indexAction()\n    {\n        // Start the session\n        Zend_Session::start();\n        \n        // Get the session ID\n        $sessionId = Zend_Session::getId();\n        \n        // Use the session ID to retrieve data from the "old" application\n        // ...\n    }\n}