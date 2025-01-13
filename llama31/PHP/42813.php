class My_Form_Decorator_HtmlTag extends Zend_Form_Decorator_HtmlTag\n{\n    public function render($content)\n    {\n        $element = $this->getElement();\n        if ($element instanceof Zend_Form_Element_Hidden) {\n            $this->setOption('class', 'hidden');\n        }\n        return parent::render($content);\n    }\n}