$form = new Zend_Form();\n\n// Adding a note for store_id which will be displayed but not editable\n$storeIdNote = new Zend_Form_Element_Note('store_id');\n$storeIdNote->setLabel('Store ID:')\n            ->setValue($storeId) // Set the value of store_id you want to display here\n            ->setAttribs(array(\n                'style' => 'display: block; margin-bottom: 10px;' // Optional: add some style if needed\n            ));\n\n$form->addElement($storeIdNote);\n\n// Continue adding other form elements...