class Admin_TestController extends Zend_Controller_Action\n{\n    protected $_flashMessenger = null;\n\n    public function init()\n    {\n        // Ensure session is started\n        Zend_Session::start();\n        \n        // Initialize FlashMessenger helper\n        $this->_flashMessenger = $this->_helper->getHelper('FlashMessenger');\n        $this->initView();\n    }\n\n    public function myAction()\n    {\n        // Add a flash message\n        $this->_flashMessenger->addMessage('test message');\n\n        // Redirect to the next action\n        $this->_helper->redirector('mynextrequest');\n    }\n\n    public function mynextrequestAction()\n    {\n        // Retrieve and dump flash messages\n        $messages = $this->_flashMessenger->getMessages();\n        Zend_Debug::dump($messages);\n        \n        // Render the view\n        $this->render();\n    }\n}