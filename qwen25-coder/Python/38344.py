# reserved_words.py\nRESERVED_WORDS = {"about", "contact", "admin", "help"}\n\n# user_registration.py\nfrom reserved_words import RESERVED_WORDS\n\ndef is_username_valid(username):\n    if not username:\n        return False\n    # Check if the username is a reserved word\n    if username.lower() in RESERVED_WORDS:\n        return False\n    # Additional checks can go here (e.g., length, characters allowed)\n    return True\n\n# Example usage\nusernames_to_test = ["john_doe", "about", "contactus"]\nfor username in usernames_to_test:\n    print(f"Username '{username}' is valid: {is_username_valid(username)}")