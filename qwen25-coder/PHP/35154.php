class MyController extends Zend_Controller_Action {\n       public function init() {\n           $ajaxContext = $this->_helper->getHelper('AjaxContext');\n           $ajaxContext->addActionContext('myAction', 'json')\n                       ->initContext();\n       }\n\n       public function myAction() {\n           // Process POST data\n           $data = $this->getRequest()->getPost();\n\n           // Prepare your response\n           $response = array(\n               'status' => 'success',\n               'message' => 'Data received!',\n               'data'   => $data,\n           );\n\n           // Assign response to view (JsonContext will handle the rest)\n           $this->view->response = $response;\n       }\n   }