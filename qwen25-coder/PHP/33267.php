function menufun_menu_link_alter(&$item, $menu) {\n     dpm($item); // Prints the $item array details to the page.\n     kint($item); // Alternatively, use Kint to inspect variables in a more structured way.\n     if ($item['link_path'] == 'logout') {\n       $item['link_title'] = 'Sign off';\n     }\n   }