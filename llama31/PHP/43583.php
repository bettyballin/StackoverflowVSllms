$fp = fopen('file.txt', 'r');\nvar_dump(is_resource($fp));  // bool(true)\n\n$notFp = 'Hello, World!';\nvar_dump(is_resource($notFp));  // bool(false)