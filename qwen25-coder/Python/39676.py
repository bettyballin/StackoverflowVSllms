def check_software_usage(license_type, user_action):\n    if license_type == "open-source":\n        if user_action in ["modify", "distribute"]:\n            return "Allowed under certain conditions"\n        elif user_action == "commercial_use_without_permission":\n            return "Foul! Unauthorized commercial use detected."\n    elif license_type == "proprietory":\n        if user_action == "copy_without_permission":\n            return "Theft or Fraud: Unauthorized copy detected."\n        elif user_action in ["modify", "distribute"]:\n            return "Unauthorized action: Requires permission."\n    return "Usage within terms"\n\n# Example usage\nprint(check_software_usage("open-source", "commercial_use_without_permission"))