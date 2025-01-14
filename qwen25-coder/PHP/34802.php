// src/Controller/FilesController.php\n\npublic function upload() {\n    $this->request->allowMethod(['post', 'put']);\n    if (!empty($this->request->data['file']['name'])) {\n        $file = $this->request->data['file'];\n        \n        // Check file type and size\n        $allowedTypes = ['application/pdf', 'image/jpeg', 'image/png']; // Add more as needed\n        if (in_array($file['type'], $allowedTypes) && $file['size'] <= 150 * 1024 * 1024) { // Check for 150MB max size\n            // Save file securely\n            $targetPath = sprintf('%s/%s', WWW_ROOT . 'uploads', $this->generateSafeFileName($file['name']));\n            if (move_uploaded_file($file['tmp_name'], $targetPath)) {\n                // Save file metadata to your database linking it to the user\n                $this->Flash->success('File uploaded successfully.');\n                return $this->redirect(['action' => 'index']);\n            }\n        } else {\n            $this->Flash->error('Invalid file type or size.');\n        }\n    }\n}\n\nprivate function generateSafeFileName($fileName) {\n    // Implement a simple safe file name generation logic\n    return md5(uniqid(rand(), true)) . '_' . preg_replace('/[^\w\-]+/', '_', strtolower($fileName));\n}