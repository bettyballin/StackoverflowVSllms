def permute(s, answer):\n    if len(s) == 0:\n        print(answer)\n        return\n    \n    for i in range(len(s)):\n        # Choose the current character\n        char = s[i]\n        # Form remaining string after removing the chosen character\n        remaining = s[:i] + s[i+1:]\n        # Recursive call\n        permute(remaining, answer + char)\n\n# Example usage:\nstring = "abc"\npermute(string, "")