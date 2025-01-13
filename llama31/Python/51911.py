def generate_username(first_name, last_name, existing_usernames):\n    base_username = (first_name + last_name).lower()\n    username = base_username\n    i = 1\n    while username in existing_usernames:\n        username = base_username + str(i)\n        i += 1\n    return username