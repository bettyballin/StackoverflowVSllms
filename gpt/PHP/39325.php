class My_View_Helper_CustomUrl extends Zend_View_Helper_Url\n{\n    public function customUrl(array $urlOptions = array(), $name = null, $reset = false, $encode = true)\n    {\n        // Retrieve current request parameters\n        $request = Zend_Controller_Front::getInstance()->getRequest();\n        $currentParams = $request->getParams();\n\n        // Merge current parameters with provided options\n        $params = array_merge($currentParams, $urlOptions);\n\n        // Generate the URL with merged parameters\n        return parent::url($params, $name, $reset, $encode);\n    }\n}