function mymodule_form($form, &$form_state) {\n  // ... (rest of your form code)\n\n  // Enable AJAX submission\n  $form['#ajax'] = array(\n    'callback' => 'mymodule_form_callback',\n    'wrapper' => 'my-form-wrapper',\n  );\n\n  return $form;\n}\n\nfunction mymodule_form_callback($form, &$form_state) {\n  // Return the updated form\n  return $form;\n}