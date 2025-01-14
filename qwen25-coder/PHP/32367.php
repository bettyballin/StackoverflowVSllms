class MyForm extends Zend_Form\n{\n    protected $_request;\n\n    public function __construct($options = null)\n    {\n        if (!isset($options['request'])) {\n            throw new InvalidArgumentException('A Zend_Controller_Request_Abstract instance is required');\n        }\n        \n        $this->_request = $options['request'];\n        unset($options['request']);\n\n        parent::__construct($options);\n    }\n\n    public function init()\n    {\n        // Example of using the request object\n        if ($this->_request->isPost()) { \n            // code here\n        }\n\n        // form elements initialization...\n    }\n}\n\n// In your controller action:\n$form = new MyForm(array('request' => $this->getRequest()));