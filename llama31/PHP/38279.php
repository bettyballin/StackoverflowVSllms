$allowedPages = array('home', 'about', 'contact');\n\nif (isset($_GET['page']) && in_array($_GET['page'], $allowedPages)) {\n    include($_GET['page'] . '.php');\n} else {\n    include('home.php');\n}