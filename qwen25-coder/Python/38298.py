import re\n\n# Built-in re module\ntext = "There are 123 numbers in this sentence"\npattern_builtin = r"\d+"\n\nmatches_builtin = re.findall(pattern_builtin, text)\nprint("Built-in:", matches_builtin)\n\n# Third-party regex library (requires installation: pip install regex)\nimport regex as re3\n\npattern_regex = r"\d+"\nmatches_regex = re3.findall(pattern_regex, text)\nprint("regex module:", matches_regex)