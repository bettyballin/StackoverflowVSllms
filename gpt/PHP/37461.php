<?php\n   // reverse_frontpage_order.module\n\n   /**\n    * Implementation of hook_init().\n    */\n   function reverse_frontpage_order_init() {\n     if (drupal_is_front_page()) {\n       // Alter the default front page query.\n       $query = db_query_range('SELECT nid FROM {node} WHERE status = 1 ORDER BY created ASC', 0, 1);\n       if ($row = db_fetch_object($query)) {\n         menu_set_active_item('node/' . $row->nid);\n       }\n     }\n   }