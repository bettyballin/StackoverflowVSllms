class My_Decorator_RichTextArea extends Zend_Form_Decorator_Abstract {\n\n    public function render($content) {\n        $element = $this->getElement();\n\n        // Add 'rich' class to existing classes or set it if no class is present\n        $classes = $element->getAttrib('class');\n        $newClasses = empty($classes) ? 'rich' : $classes . ' rich';\n        $element->setAttrib('class', $newClasses);\n\n        // Render the element with the updated attribute\n        return $content;\n    }\n}\n\n// Usage in your form implementation\n$textarea = new Zend_Form_Element_Textarea('content');\n$textarea->setLabel('Content')\n         ->setDescription('Enter your content here.')\n         ->addDecorator(new My_Decorator_RichTextArea());\n\n$form->addElement($textarea);