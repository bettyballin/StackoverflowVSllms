import re\n\ndef find_safe_cut_index(text, min_length=200):\n    # Regular expression pattern for matching BBcodes\n    bbcode_pattern = r'\[(.*?)\]'\n\n    # Initialize variables to keep track of the position and state\n    index = 0\n    inside_bbcode = False\n\n    while index < len(text):\n        if inside_bbcode:\n            # If we are inside a BBCode, find its end\n            match = re.match(bbcode_pattern, text[index:])\n            if match:\n                bbcode_length = match.end()\n                index += bbcode_length\n                inside_bbcode = False\n        else:\n            # If we are outside of a BBCode, search for the next BBCode\n            match = re.search(bbcode_pattern, text[index:])\n            if match:\n                bbcode_start_index = match.start() + index\n                if bbcode_start_index >= min_length:\n                    return bbcode_start_index  # Found a safe place to cut\n                else:\n                    index += bbcode_start_index\n                    inside_bbcode = True\n            else:\n                # No more BBCode found, just check the remaining length\n                if len(text) - index > min_length:\n                    return min_length + index\n                else:\n                    return len(text)\n\n    return min(index, len(text))\n\n# Example usage\narticle_text = "This is a sample text with [b]bold[/b] words and [url=http://example.com]a link[/url]."\nsafe_index = find_safe_cut_index(article_text, 50)\nprint(f"Safe cut index: {safe_index}")