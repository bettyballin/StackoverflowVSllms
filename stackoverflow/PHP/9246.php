class My_View_Helper_Url extends Zend_View_Helper_Url\n{    \n    public function url(array $urlOptions = array(), $name = null, $reset = false, $encode = true)\n    {\n        if (isset($urlOptions['anchor']) && !empty($urlOptions['anchor']))\n        {\n            $anchor = $urlOptions['anchor'];\n            unset($urlOptions['anchor']);\n        }\n        else\n        {\n            $anchor = '';\n        }\n\n        return parent::url($urlOptions, $name, $reset, $encode).$anchor;\n    }\n}