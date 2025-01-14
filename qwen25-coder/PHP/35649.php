function submit_new() {\n    // Configuration for the CodeIgniter Upload Library\n    $config['upload_path'] = './images/';\n    $config['allowed_types'] = 'gif|jpg|png';\n    $config['max_size'] = 2048;  // max size in kilobytes (2MB)\n    $config['max_width'] = 1024;\n    $config['max_height'] = 768;\n\n    // Load the CodeIgniter Upload Library with the specified configuration\n    $this->load->library('upload', $config);\n\n    // Attempt to upload the file\n    if (!$this->upload->do_upload('image')) {\n        // If the upload failed, set error message and redirect or do something else\n        $error = array('error' => $this->upload->display_errors());\n        print_r($error);\n        return;  // Exit function to prevent inserting invalid data into the database\n    } else {\n        // If the upload was successful\n        $data = array('upload_data' => $this->upload->data());  // Retrieve uploaded file data\n\n        // Prepare your data for insertion into the database\n        $post_data = [\n            'image' => $config['upload_path'] . $data['upload_data']['file_name'],  // Store the path to the image in the database\n            // Add other form fields here, e.g.:\n            'title' => $this->input->post('title'),\n            'description' => $this->input->post('description')\n        ];\n\n        // Insert data into your database\n        $this->db->insert('post', $post_data);\n\n        // Redirect to another page or show a success message\n        redirect('bro');\n    }\n}