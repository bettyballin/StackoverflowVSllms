public function saveFromFlash($sessionId = null) {\n    if ($this->request->is('post')) {\n        // Check if file was uploaded without errors\n        if (empty($_FILES['data']['error']['FileUpload']['file'])) {\n            $fileName = basename($_FILES["data"]["name"]["FileUpload"]["file"]);\n            $fileType = pathinfo($fileName,PATHINFO_EXTENSION);\n\n            // Move the uploaded file to a new location:\n            move_uploaded_file(\n                $_FILES['data']['tmp_name']["FileUpload"]["file"],\n                "uploads/" . htmlspecialchars( $fileName)\n            );\n            \n            // Save logic here\n            if ($this->FileUpload->save($this->request->getData())) {\n                return ['success' => true, 'message' => 'File uploaded successfully.'];\n            }\n        } else {\n            $this->setUploadError('No upload or file error');\n            return false;\n        }\n    }\n}