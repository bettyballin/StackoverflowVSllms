def can_be_made_nice(s):\n    vowels = set('AEIOU')\n    \n    # Check for sequences in the string\n    i = 0\n    while i < len(s):\n        if s[i] in vowels:\n            # Count vowels\n            count_vowels = 0\n            while i < len(s) and (s[i] in vowels or s[i] == '?'):\n                if s[i] in vowels:\n                    count_vowels += 1\n                if count_vowels >= 3:\n                    return False  # More than 2 vowels in a row without '?' to break it\n                i += 1\n        else:\n            # Count consonants\n            count_consonants = 0\n            while i < len(s) and (s[i] not in vowels or s[i] == '?'):\n                if s[i] != '?' and s[i] not in vowels:\n                    count_consonants += 1\n                if count_consonants >= 5:\n                    return False  # More than 4 consonants in a row without '?' to break it\n                i += 1\n        i += 1\n    \n    return True\n\n# Test cases\nprint(can_be_made_nice("EE?FFFF"))  # Output: False\nprint(can_be_made_nice("H??LOWOR??"))  # Output: True