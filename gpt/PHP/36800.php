protected function _initActionHelpers()\n{\n    Zend_Controller_Action_HelperBroker::addHelper(new My_Controller_Action_Helper_AjaxResponse());\n}