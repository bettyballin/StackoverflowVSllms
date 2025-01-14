import re\n\ndef anonymize_email(email):\n    if not re.match(r"[^@]+@[^@]+\.[^@]+", email):\n        return None  # Invalid email format\n    \n    parts = email.split('@')\n    username_part = parts[0][0] + '*' * (len(parts[0]) - 2) + parts[0][-1]\n    \n    domain_part = '*'.join(part if i == len(parts[1].split('.')) - 1 else part[:1] + '*' \n                           for i, part in enumerate(parts[1].split('.')))\n    \n    return username_part + '@' + domain_part\n\n# Example usage\nprint(anonymize_email("example@example.com"))