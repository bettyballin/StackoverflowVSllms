if ($this->form_validation->run() == FALSE) {\n    // Validation failed, load the form again with errors\n    $this->load->view('your_form_view');\n} else {\n    // Validation passed, process the input\n    $textarea_input = $this->input->post('textarea_input', TRUE); // TRUE enables XSS filtering\n    // Now you can safely store $textarea_input in your database\n}