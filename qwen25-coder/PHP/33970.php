// In a file named IndexController.php\nnamespace Application\Controller;\n\nuse Zend\Mvc\Controller\AbstractActionController;\nuse Zend\View\Model\ViewModel;\n\nclass IndexController extends AbstractActionController\n{\n    public function indexAction()\n    {\n        // Get data from model, if needed\n        $data = ['message' => 'Hello, World!'];\n\n        // Return ViewModel populated with data\n        return new ViewModel($data);\n    }\n}