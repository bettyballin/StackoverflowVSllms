class MyController extends Zend_Controller_Action\n{\n    public function addAction()\n    {\n        // Get the necessary data from the request\n        // ...\n\n        // Create a new element\n        $newElement = new Zend_Form_Element_Text('new-element');\n\n        // Return the new element as a response\n        $this->getResponse()->setBody($newElement->render());\n    }\n}