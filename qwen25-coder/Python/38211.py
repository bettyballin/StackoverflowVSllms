def rabin_karp(text, pattern):\n    q = 101  # A prime number for modulo operation\n    d = 256  # Number of characters in the input alphabet\n\n    n = len(text)\n    m = len(pattern)\n\n    p_hash = 0  # Hash value for pattern\n    t_hash = 0  # Hash value for text\n    h = 1\n\n    result = []\n\n    # The value of h would be "pow(d, m-1)%q"\n    for i in range(m - 1):\n        h = (h * d) % q\n\n    # Calculate the hash value of pattern and first window of text\n    for i in range(m):\n        p_hash = (d * p_hash + ord(pattern[i])) % q\n        t_hash = (d * t_hash + ord(text[i])) % q\n\n    # Slide the pattern over text one by one\n    for i in range(n - m + 1):\n        # Check the hash values of current window of text and pattern.\n        if p_hash == t_hash:\n            # If the hash values match then only check for characters one by one\n            if text[i:i + m] == pattern:\n                result.append(i)\n\n        # Calculate hash value for next window of text: Remove leading digit, add trailing digit\n        if i < n - m:\n            t_hash = (d * (t_hash - ord(text[i]) * h) + ord(text[i + m])) % q\n\n            # We might get negative value of t_hash, converting it to positive\n            if t_hash < 0:\n                t_hash = t_hash + q\n\n    return result\n\n# Example usage\ntext = "ababcabcabababd"\npattern = "ababd"\nindexes = rabin_karp(text, pattern)\nprint(indexes)  # Output: [10]