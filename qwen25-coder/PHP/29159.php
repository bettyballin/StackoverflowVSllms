// Run the form validation\n$result = $this->form_validation->run();\n\nif ($result) {\n    // Validation passed, proceed with further processing\n} else {\n    // Validation failed, get errors in array format\n    $errors = $this->form_validation->error_array();\n    \n    // Convert errors array to JSON and send it back to AJAX call\n    echo json_encode($errors);\n}