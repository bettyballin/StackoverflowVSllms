// module/Application/src/Controller/IndexController.php\nnamespace Application\Controller;\n\nuse Laminas\Mvc\Controller\AbstractActionController;\nuse Laminas\View\Model\ViewModel;\n\nclass IndexController extends AbstractActionController\n{\n    public function indexAction()\n    {\n        return new ViewModel([\n            'message' => 'Hello World!',\n        ]);\n    }\n}