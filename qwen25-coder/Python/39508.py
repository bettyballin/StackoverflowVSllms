import win32security\nimport ntsecuritycon as con\n\ndef get_ntfs_permissions(path):\n    sd = win32security.GetFileSecurity(path, win32security.DACL_SECURITY_INFORMATION)\n    dacl = sd.GetSecurityDescriptorDacl()\n    \n    permissions_dict = {}\n    for ace in dacl:\n        (ace_type, ace_flags), sid = ace.GetAce()\n\n        user_name, domain_name, type = win32security.LookupAccountSid(None, sid)\n\n        if not permissions_dict.get(user_name):\n            permissions_dict[user_name] = []\n\n        # Translate ACE mask to permission names\n        for perm in dir(con):\n            if perm.startswith('FILE_') or perm.startswith('GENERIC_'):\n                if ace[1] & getattr(con, perm):\n                    permissions_dict[user_name].append(perm)\n\n    return permissions_dict\n\n# Example usage\npath = r'C:\Path\To\FileOrFolder'\nperms = get_ntfs_permissions(path)\nfor user, perms in perms.items():\n    print(f'{user}: {", ".join(perms)}')