function foo_form_submit($form_id, &$form_state) {\n  $validators = array('file_validate_mime' => array('text/csv'));\n  $dest = 'sites/phoenix.dev/files';\n  $uploaded_file = file_save_upload('upload', $validators, $dest);\n  // some other stuff\n}