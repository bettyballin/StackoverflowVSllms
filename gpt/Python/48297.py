import re\n\ntext = """\nHere is some text with URLs:\nhttp://example.com\nand some more text.\nhttp://another-example.com/page\nEnd of text.\n"""\n\n# Regular expression to match URLs\nurl_pattern = r'http://[a-zA-Z0-9\/\.]*'\n\n# Regular expression to match everything that is not a URL\ninverse_pattern = r'((?!http://[a-zA-Z0-9\/\.]*).)+'\n\n# Use re.findall to extract non-URL text\nresult = re.findall(inverse_pattern, text, re.DOTALL)\n\n# Join the result to get the text without URLs\nnon_url_text = ''.join(result)\n\nprint(non_url_text)