import os\nimport stat\n\ndef get_owner_and_group(directory):\n    try:\n        # Get the status of the specified path\n        status = os.stat(directory)\n        \n        # Extract owner (UID) and group (GID)\n        uid = status.st_uid\n        gid = status.st_gid\n        \n        return {'owner_id': uid, 'group_id': gid}\n    except OSError as e:\n        print(f"Error accessing {directory}: {e}")\n        return None\n\n# Example usage\ndirectory_path = '/path/to/directory'\nowner_and_group = get_owner_and_group(directory_path)\nif owner_and_group:\n    print(f"Owner ID: {owner_and_group['owner_id']}, Group ID: {owner_and_group['group_id']}")