// Get the singleton instance\n$registry = Registry::getInstance();\n\n// Set a value\n$registry->set('page', $page);\n\n// Get a value\n$pageValue = $registry->get('page');