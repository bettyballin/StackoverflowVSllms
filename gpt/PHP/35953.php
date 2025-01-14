// application/controllers/ErrorController.php\n   class ErrorController extends Zend_Controller_Action\n   {\n       public function errorAction()\n       {\n           $errors = $this->_getParam('error_handler');\n           \n           if (!$errors) {\n               $this->view->message = 'You have reached the error page';\n               return;\n           }\n\n           switch ($errors->type) { \n               case Zend_Controller_Plugin_ErrorHandler::EXCEPTION_NO_ROUTE:\n               case Zend_Controller_Plugin_ErrorHandler::EXCEPTION_NO_CONTROLLER:\n               case Zend_Controller_Plugin_ErrorHandler::EXCEPTION_NO_ACTION:\n                   // 404 error -- controller or action not found\n                   $this->getResponse()->setHttpResponseCode(404);\n                   $this->view->message = 'Page not found';\n                   break;\n               default:\n                   // application error\n                   $this->getResponse()->setHttpResponseCode(500);\n                   $this->view->message = 'Application error';\n                   break;\n           }\n\n           // Pass the exception to the view\n           $this->view->exception = $errors->exception;\n           $this->view->request   = $errors->request;\n       }\n   }