// /application/controllers/ImageController.php\n   class ImageController extends Zend_Controller_Action {\n\n       public function serveAction() {\n           $filePath = trim($this->_request->getParam('filepath'), './\\');\n\n           // Validate and sanitize the file path.\n           if (empty($filePath) || !preg_match('/^\d+\/\d+\/\d+\/[^.]+?\.(jpg|png|pdf)$/i', $filePath)) {\n               throw new Exception("Invalid image path provided");\n           }\n\n           // Construct full path to the image\n           $fullPath = APPLICATION_PATH . '/../filespool/' . $filePath;\n\n           // Check if file exists and is readable.\n           if (!file_exists($fullPath) || !is_readable($fullPath)) {\n               throw new Exception("Image file does not exist or is unreadable");\n           }\n\n           // Set headers\n           header('Content-Type: ' . mime_content_type($fullPath));\n           header('Content-Disposition: inline; filename="' . basename($filePath) . '"');\n           header('Cache-Control: private, max-age=10800, pre-check=10800');\n           header('Pragma: public');\n\n           // Read and serve the file\n           readfile($fullPath);\n\n           exit(); // Ensure no further output\n       }\n   }