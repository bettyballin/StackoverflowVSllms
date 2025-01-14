// In your controller\nfunction autocomplete() {\n  $this->autoRender = false;\n  $term = $this->request->query['term'];\n  $results = $this->YourModel->find('all', array(\n    'conditions' => array(\n      'YourModel.name LIKE' => '%' . $term . '%'\n    ),\n    'fields' => array('YourModel.id', 'YourModel.name')\n  ));\n  $suggestions = array();\n  foreach ($results as $result) {\n    $suggestions[] = array(\n      'id' => $result['YourModel']['id'],\n      'value' => $result['YourModel']['name']\n    );\n  }\n  echo json_encode($suggestions);\n}