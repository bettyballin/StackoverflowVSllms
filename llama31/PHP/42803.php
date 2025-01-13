$view = new view();\n$view->name = 'taxonomy_term_nodes';\n$view->description = 'Lists taxonomy terms with tagged nodes underneath';\n$view->tag = 'taxonomy term';\n$view->base_table = 'term_data';\n$view->human_name = 'Taxonomy term nodes';\n\n// Relationship: Taxonomy term: Node\n$view->relationship = array(\n  'term_node' => array(\n    'table' => 'node',\n    'field' => 'nid',\n  ),\n);\n\n// Filter: Node: Updated date\n$view->filter = array(\n  'node_updated' => array(\n    'table' => 'node',\n    'field' => 'changed',\n    'operator' => '>',\n    'value' => -3,\n  ),\n);\n\n// Field: Node: Title\n$view->field = array(\n  'node_title' => array(\n    'table' => 'node',\n    'field' => 'title',\n  ),\n);\n\n// Argument: Taxonomy term: Term\n$view->argument = array(\n  'term_term' => array(\n    'table' => 'term_data',\n    'field' => 'tid',\n  ),\n);\n\n// Display: Unordered list\n$view->display = array(\n  'type' => 'list',\n  'grouping' => 'term_term',\n);