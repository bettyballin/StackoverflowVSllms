# Password length validation example\nmin_length = 12  # a reasonable minimum length\nmax_length = float('inf')  # no maximum length\n\ndef validate_password(password):\n    if len(password) < min_length:\n        return False\n    return True