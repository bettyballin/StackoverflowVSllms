import os\nimport pwd\nimport grp\n\ndef get_owner_group(path):\n    stat = os.stat(path)\n    owner_id = stat.st_uid\n    group_id = stat.st_gid\n    owner_name = pwd.getpwuid(owner_id).pw_name\n    group_name = grp.getgrgid(group_id).gr_name\n    return owner_name, group_name\n\npath = '/path/to/your/directory'\nowner_name, group_name = get_owner_group(path)\nprint(f"Owner: {owner_name}")\nprint(f"Group: {group_name}")