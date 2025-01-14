// MyApplication_Controller_IndexController.php\nclass MyApplication_IndexController extends Zend_Controller_Action\n{\n    public function uploadAction()\n    {\n        $form = new MyApplication_Form_UploadImage();\n        \n        if ($this->getRequest()->isPost()) {\n            if ($form->isValid($_POST)) {\n                $data = $form->getValues();\n\n                // Retrieve the file information\n                $adapter = new Zend_File_Transfer_Adapter_Http();\n                \n                $files = $adapter->getFileInfo('image');\n                $filename = $files['image']['name'];\n                $contentType = $files['image']['type'];\n\n                // Read the file content into a variable\n                $fileContent = file_get_contents($files['image']['tmp_name']);\n\n                // Insert data into database\n                $db = Zend_Db_Table_Abstract::getDefaultAdapter();\n                $sql = "INSERT INTO images (name, content_type, image_data) VALUES (?, ?, ?)";\n                $stmt = $db->prepare($sql);\n                $stmt->execute(array($filename, $contentType, $fileContent));\n\n                echo 'Image uploaded successfully!';\n            } else {\n                $form->populate($_POST);\n            }\n        }\n\n        $this->view->form = $form;\n    }\n}