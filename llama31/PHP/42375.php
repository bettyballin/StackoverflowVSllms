function mymodule_form_alter(&$form, &$form_state, $form_id) {\n  if ($form_id == 'webform_client_form_' . $form['#webform_id']) {\n    $form['#prefix'] = '<div>' . filter_xss_admin(variable_get('my_rich_text', '')) . '</div>';\n  }\n}