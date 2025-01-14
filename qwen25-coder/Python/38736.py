def is_alphanumeric(user_id):\n    has_alpha = any(c.isalpha() for c in user_id)\n    has_digit = any(c.isdigit() for c in user_id)\n    return has_alpha and has_digit\n\n# Example usage\nuser_id = "abc123"\nif not is_alphanumeric(user_id):\n    print("User ID must contain at least one letter and one number.")