// In your template page\nmymodule_save_session('my_key', 'Hello, World!');\n$value = mymodule_load_session('my_key');\nprint $value; // prints "Hello, World!"