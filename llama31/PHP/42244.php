function get_request_data() {\n    $data = array_merge($_GET, $_POST);\n    return (object)$data;\n}