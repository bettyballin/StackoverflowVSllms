function submit_form($rec_id) {\n    $this->load->library('form_validation');\n\n    // Set validation rules\n    $this->form_validation->set_rules('name', 'Name', 'required|trim');\n    $this->form_validation->set_rules('email', 'Email Address', 'required|trim|valid_email');\n\n    // Run form validation\n    if ($this->form_validation->run() === FALSE) {\n        // Store the errors in flashdata\n        $this->session->set_flashdata('errors', validation_errors());\n\n        // Redirect back to the original page with a flash message\n        redirect("property/rentals/$rec_id");\n    } else {\n        // If successful, insert data into database (example)\n        $data = array(\n            'name' => $this->input->post('name'),\n            'email' => $this->input->post('email')\n        );\n\n        // Simulated insert operation\n        // $this->Your_model->insert($data);\n\n        // Store success message in flashdata\n        $this->session->set_flashdata('success', "Data inserted successfully.");\n\n        // Redirect back to the original page with a flash message\n        redirect("property/rentals/$rec_id");\n    }\n}\n\n// In your property/rentals controller method\nfunction rentals($rec_id) {\n    // Load the view and pass necessary data\n    $data['rec_id'] = $rec_id;\n    $data['errors'] = $this->session->flashdata('errors');\n    $data['success'] = $this->session->flashdata('success');\n\n    $this->load->view('property/rentals_view', $data);\n}\n\n// In your view file, you can display the flash messages and populate fields like this:\n<div>\n    <?php if (isset($errors)): ?>\n        <div class="error">\n            <?= $errors; ?>\n        </div>\n    <?php endif; ?>\n\n    <?php if (isset($success)): ?>\n        <div class="success">\n            <?= $success; ?>\n        </div>\n    <?php endif; ?>\n\n    <!-- Your form here -->\n    <form action="<?= site_url("property/submit_form/$rec_id"); ?>" method="post">\n        <input type="text" name="name" value="<?php echo set_value('name'); ?>">\n        <input type="email" name="email" value="<?php echo set_value('email'); ?>">\n        <button type="submit">Submit</button>\n    </form>\n</div>