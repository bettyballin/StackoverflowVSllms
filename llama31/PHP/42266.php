$store_id = new Zend_Form_Element_Hidden('store_id');\n$store_id->setValue('12345');\n\n$store_id_label = new Zend_Form_Element_Note('store_id_label');\n$store_id_label->setValue('Store ID: 12345');\n\n$form->addElement($store_id);\n$form->addElement($store_id_label);