import <module_name>\nfile_path = <module_name>.__file__\n\nimport idlelib.pyshell\nidlelib.pyshell.main(['-n', file_path])