import re\n\nstrings = [\n    "785*()&!~`a",\n    "##$%$~2343",\n    "455frt&*&*"\n]\n\npattern = r'.*[a-zA-Z].*'\nmatching_strings = [s for s in strings if re.match(pattern, s)]\n\nprint(matching_strings)