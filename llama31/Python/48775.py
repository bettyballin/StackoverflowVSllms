# Python\nimport importlib\n\ndef load_user_module(module_name):\n    module = importlib.import_module(module_name)\n    # Call a function from the loaded module\n    module.user_function()\n\nload_user_module("user_module")