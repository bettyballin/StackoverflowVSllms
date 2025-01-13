// In your Model\nfunction afterSave($created) {\n    // Import the Email component\n    App::import('Component', 'Email');\n\n    // Initialize the Email component\n    $email = new EmailComponent();\n\n    // Set up the email\n    $email->delivery = 'smtp';\n    $email->template = 'default';\n    $email->sendAs = 'text';\n    $email->from = 'email';\n    $email->to = 'email';\n    $email->subject = 'Error';\n\n    // Send the email\n    $email->send();\n}