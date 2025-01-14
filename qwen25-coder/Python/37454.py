from random import choice\n\ndef generate_pronounceable_password(length=10, language='en'):\n    # Define syllables for English. You can expand this with syllables from other languages.\n    syllables = {\n        'en': ['ba', 'be', 'bi', 'bo', 'bu', 'da', 'de', 'di', 'do', 'du']\n    }\n    \n    if language not in syllables:\n        raise ValueError(f"No syllables defined for {language}.")\n        \n    password = ''.join(choice(syllables[language]) for _ in range(length // 2 + length % 2))\n    return password\n\n# Example usage\nprint(generate_pronounceable_password(10, 'en'))