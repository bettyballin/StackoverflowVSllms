# Example pre-commit hook in Python\n#!/usr/bin/env python\nimport subprocess\n\nsensitive_strings = ["secret1", "secret2"]\n\ndef check_sensitive_strings(file_path):\n    with open(file_path, 'r') as file:\n        for line in file:\n            for string in sensitive_strings:\n                if string in line:\n                    print(f"Error: Sensitive string '{string}' found in {file_path}")\n                    return 1\n    return 0\n\nsubprocess.run(["git", "diff", "--cached", "--name-only"]).stdout.decode().splitlines():\n    for file_path in files:\n        if check_sensitive_strings(file_path):\n            sys.exit(1)