$autocomplete = new ZendX_JQuery_Form_Element_AutoComplete('club');\n$autocomplete->setLabel('Club')\n             ->setJqParams(array(\n                 'url' => '/mywebsite/mycontroller/autocomplete',\n                 'extraParams' => array('country' => new Zend_Json_Expr("$('#country').val()"))\n             ))\n             ->addFilter('StringTrim')\n             ->setRequired(true);