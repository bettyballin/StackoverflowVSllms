$modules = array(\n    'home'       => 'home',\n    'login'      => 'login',\n    'forum'      => 'forum',\n    'topic'      => 'topic',\n    'post'       => 'post',\n    'profile'    => 'profile',\n    'moderate'   => 'moderate',\n    'search'     => 'search',\n    'ucp'        => 'usercp',\n    'ucc'        => 'usercp',\n    'pm'         => 'pm',\n    'members'    => 'members',\n    'boardrules' => 'boardrules',\n    'groups'     => 'groupcp',\n    'help'       => 'help',\n    'misc'       => 'misc',\n    'tags'       => 'tags',\n    'attach'     => 'attach'\n);\n\nif (isset($_GET['module']) && in_array($_GET['module'], $modules)) {\n    $module = basename($_GET['module']); // Ensure the module name is safe\n    include $module . '.php';\n} else {\n    echo "Invalid module specified.";\n}