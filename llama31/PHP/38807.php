// In your controller\npublic function init()\n{\n    $format = $this->_getParam('format');\n    if ($format == 'wml') {\n        $this->_helper->viewRenderer->setViewSuffix('wml');\n    } else {\n        $this->_helper->viewRenderer->setViewSuffix('phtml');\n    }\n}