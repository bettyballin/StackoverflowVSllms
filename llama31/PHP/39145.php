$page = $_GET['page'];\n$data = file_get_contents($page . '.php');\n$json_data = json_encode($data);\necho $_GET['callback'] . '(' . $json_data . ')';