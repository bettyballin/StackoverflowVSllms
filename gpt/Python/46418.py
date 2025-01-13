import configparser\n\ndef parse_inf_file(file_path):\n    config = configparser.ConfigParser(allow_no_value=True, delimiters=('='))\n    config.optionxform = str  # Preserve the case of keys\n\n    with open(file_path, 'r') as inf_file:\n        content = inf_file.read()\n        content = content.replace(' =', '=').replace('= ', '=')  # Fix spacing around equals signs\n        config.read_string(content)\n\n    return config\n\n# Example usage\nfile_path = 'path_to_your_inf_file.inf'\nconfig = parse_inf_file(file_path)\n\n# Access sections and values\nfor section in config.sections():\n    print(f'Section: {section}')\n    for key, value in config.items(section):\n        print(f'  {key}: {value}')\n\n# Access specific values\nversion_signature = config['Version']['Signature']\nprint(f'Version Signature: {version_signature}')