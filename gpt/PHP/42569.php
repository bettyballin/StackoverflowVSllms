<?php\nclass Form_Audience extends Zend_Form_SubForm\n{\n    public function init()\n    {\n        $this->setMethod('post');\n        $this->setLegend('Audience Details');\n\n        $this->addElement('text', 'audience_total', array(\n            'label'      => 'Audience Total :',\n            'required'   => true,\n            'filters'    => array('Digits'),\n            'size'       => 15,\n            'validators' => array(\n                'Digits',\n                array('GreaterThan', false, array('min' => 0)) // Add GreaterThan validator\n            )\n        ));\n    }\n\n    // .... remaining code .....\n}