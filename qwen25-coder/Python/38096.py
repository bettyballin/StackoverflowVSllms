import re\n\ndef split_string(input_string, patterns):\n    results = [(input_string, False)]  # Start with the entire input string as not matched\n    \n    for pattern in patterns:\n        new_results = []\n        regex = re.compile(pattern)\n        \n        for text, was_matched in results:\n            if was_matched:\n                # No need to split a segment that already matched a previous pattern\n                new_results.append((text, was_matched))\n            else:\n                parts = list(regex.split(text))  # Split the non-matched segments\n                matches = regex.finditer(text)  # Find all matches within this segment\n                \n                match_indices = [(m.start(), m.group()) for m in matches]\n                \n                start_index = 0\n                for index, match_text in match_indices:\n                    # Add part before match (if any)\n                    if index > start_index:\n                        new_results.append((text[start_index:index], False))\n                    \n                    # Add the match itself\n                    new_results.append((match_text, True))\n                    \n                    start_index = index + len(match_text)\n                \n                # If there's remaining part after last match\n                if start_index < len(text):\n                    new_results.append((text[start_index:], False))\n        \n        results = new_results\n    \n    return [segment for segment, matched in results], {i: "match" if m else "non-match" for i, (s, m) in enumerate(results)}\n\n# Example usage\ninput_string = "abcdefgh"\npatterns = ["bc", "f"]\nsegments, match_info = split_string(input_string, patterns)\n\nprint("Segments:", segments)\nprint("Match Info:", match_info)