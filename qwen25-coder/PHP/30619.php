function mymodule_form_alter(&$form, \Drupal\Core\Form\FormStateInterface $form_state, $form_id) {\n  if ($form_id == 'search_block_form') {\n    // Change the default placeholder text to "Search here..."\n    $form['keys']['#attributes']['placeholder'][] = t('Search here...');\n  }\n}