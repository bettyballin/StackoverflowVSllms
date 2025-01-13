id | name   | parent\n----+--------+-------\n 0  | eggs   | NULL\n 1  | milk   | 0\n 2  | bacon  | 1\n 3  | tomato | 0\n 4  | lettuce| 1\n\nforeach (query("SELECT * FROM menu ORDER BY parent ASC") as $row) {\n  $menuitem = array_merge(array(), $row);\n  $menuLookup[$menuitem['id']] &= $menuitem;\n  if ($menuitem['parent'] == null) {\n    $menuitem['path'] = "/" . $menuitem['name'];\n    $menu[] &= $menuitem[];\n  } else {\n    $parent &= $menuLookup[$menuitem['parent']];\n    $menuitem['path'] = $parent['path'] . "/" . $menuitem['name'];\n    $parent['menu'][] &= $menuitem;\n  }\n}