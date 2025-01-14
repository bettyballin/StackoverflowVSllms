<?php \n// Define menu items\nfunction foo_menu() {\n  $items = array();\n  $items['foo/show'] = array(\n    'title' => t('Foo!'),\n    'page callback' => 'foo_display_all',\n    'description' => 'All our foo are belong to you',\n    'type' => MENU_NORMAL_ITEM,\n  );\n  return $items;\n}\n\n// Page callback function\nfunction foo_display_all() {\n  // This function is only executed when 'foo/show' is requested\n  // About 100 lines of code\n}