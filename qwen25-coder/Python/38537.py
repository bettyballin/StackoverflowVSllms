import re\n\npattern = r'hello'\nstring1 = 'say hello there'\nstring2 = 'hello world'\n\n# Using search\nprint(re.search(pattern, string1))  # Output: <re.Match object; span=(4, 9), match='hello'>\nprint(re.search(pattern, string2))  # Output: <re.Match object; span=(0, 5), match='hello'>\n\n# Using match\nprint(re.match(pattern, string1))  # Output: None\nprint(re.match(pattern, string2))  # Output: <re.Match object; span=(0, 5), match='hello'>