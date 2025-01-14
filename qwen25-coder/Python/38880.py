import re\nimport dns.resolver\n\ndef validate_email(email):\n    # Simple regex for basic syntax check\n    pattern = r"^[^@\s]+@[^@\s]+\.[^@\s]+$"\n    if not re.match(pattern, email):\n        return False\n    \n    local_part, domain = email.split('@')\n    \n    # Validate local part (example: basic length check)\n    if len(local_part) > 64:\n        return False\n    \n    # Basic domain validation\n    if not re.match(r"^([a-zA-Z0-9][a-zA-Z0-9-]*\.)+[a-zA-Z]{2,}$", domain):\n        return False\n    \n    # DNS lookup for MX record (basic existence check)\n    try:\n        dns.resolver.resolve(domain, 'MX')\n    except dns.resolver.NXDOMAIN:\n        return False\n    except dns.resolver.NoAnswer:\n        return False\n    \n    return True\n\n# Example usage\nemail = "example@test.com"\nprint(validate_email(email))