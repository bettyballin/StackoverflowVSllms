import re\n\nt = '@abc @def My email is red@hjk.com'\n\n# Use regex to find all words starting with '@' and capture the rest\nmatch = re.match(r"(@\w+\s)*(.*)", t)\n\nif match:\n    names = [name[1:] for name in match.group(0).split() if name.startswith('@')]\n    s = match.group(2)\nelse:\n    names = []\n    s = ""\n\nprint(l=names)  # Output: l=['abc', 'def']\nprint(s=s)      # Output: s='My email is red@hjk.com'