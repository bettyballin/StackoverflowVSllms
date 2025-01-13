class My_Form_Decorator_ButtonSpan extends Zend_Form_Decorator_Abstract\n{\n    public function render($content)\n    {\n        $element = $this->getElement();\n        $label   = $element->getLabel();\n        \n        $html = '<button ' . $this->_htmlAttribs($element->getAttribs()) . '>';\n        $html .= '<span>' . $label . '</span>';\n        $html .= '</button>';\n        \n        return $html;\n    }\n}