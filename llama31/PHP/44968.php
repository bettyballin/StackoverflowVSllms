// Get the current domain\n$domain = $_SERVER['HTTP_HOST'];\n\n// Set a unique session namespace for each domain\n$sessionNamespace = 'session_' . $domain;\n\n// Start the session with the namespace\nsession_name($sessionNamespace);\nsession_start();\n\n// Now, when you set a session variable, it will be specific to the current domain\n$_SESSION['cart'] = array('item1', 'item2');