use Zend\Form\Form;\nuse Zend\Form\Element;\n\n$form = new Form('item-form');\n\n// Example: Adding multiple checkboxes for a list of items\n$items = ['apple', 'banana', 'cherry'];\n\nforeach ($items as $item) {\n    $checkbox = new Element\Checkbox($item);\n    $checkbox->setLabel("Select " . ucfirst($item))\n             ->setValueOptions(['value' => 1, 'label' => '']);\n    // Set the name to include square brackets\n    $checkbox->setName('item[]');\n    \n    $form->add($checkbox);\n}\n\n// Optionally set form attributes\n$form->setAttribute('method', 'post');\n\n// Render the form in your view script using a form view helper or manually