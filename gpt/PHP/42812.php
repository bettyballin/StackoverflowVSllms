// In your php.ini configuration file\nsession.save_handler = redis\nsession.save_path = "tcp://127.0.0.1:6379"\n\n// Alternatively, you can set these options in your PHP code\nini_set('session.save_handler', 'redis');\nini_set('session.save_path', 'tcp://127.0.0.1:6379');\n\nsession_start();\n$_SESSION['key'] = 'value';