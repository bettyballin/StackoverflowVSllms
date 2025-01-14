import re\n\ndef contains_invalid_characters(registry_path):\n    # Define a set of invalid characters for registry keys and value names\n    invalid_characters = r'[<>:"/\\|?*\x00]'\n    \n    # Check if the path contains any invalid characters\n    if re.search(invalid_characters, registry_path):\n        return True\n    return False\n\n# Example usage\nregistry_path = "HKEY_LOCAL_MACHINE\\Software\\MyApp*\\Settings"\nif contains_invalid_characters(registry_path):\n    print("The path contains invalid characters.")\nelse:\n    print("The path is valid.")