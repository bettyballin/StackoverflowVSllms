// Application/Controller/ImageController.php\nclass ImageController extends Zend_Controller_Action\n{\n    public function uploadAction()\n    {\n        $form = new Application_Form_ImageUpload();\n\n        if ($this->getRequest()->isPost()) {\n            if ($form->isValid($this->getRequest()->getPost())) {\n                $file = $form->image->getFileName();\n                $imageData = file_get_contents($file);\n\n                $imageModel = new Application_Model_Image();\n                $imageModel->insertImage($imageData);\n\n                $this->view->message = 'Image uploaded successfully!';\n            }\n        }\n\n        $this->view->form = $form;\n    }\n}