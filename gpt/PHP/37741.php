session_start();\n\n$template = unserialize($_SESSION['template']);\n$prodid = $_GET['product_id'];\n$template->addItem($prodid);\necho var_dump($template->getItems());\n\n$_SESSION['template'] = serialize($template);\n\n// Debugging: Check if the session is correctly updated\nerror_log("Updated template: " . print_r($template, true));