// Example to set idekey dynamically in your application entry point\n$xdebugIdeKey = 'dev1_key'; // Developer should change this value as per their setup\nputenv("XDEBUG_CONFIG=idekey=$xdebugIdeKey");