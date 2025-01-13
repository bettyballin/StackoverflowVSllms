import re\n\ndef find_safe_index(text, min_length=200):\n    # Find all BBCodes (start and end)\n    bbcodes = re.findall(r'\[(\w+)[^]]*\](.*?)\[/\1\]', text)\n    standalone_bbcodes = re.findall(r'\[(\w+)\|([^\]]+)\]', text)\n\n    # Find the first index that is not inside any BBCode\n    safe_index = min_length\n    while True:\n        # Check if the index is inside any BBCode\n        if any(start <= safe_index < end for start, end in [(m.start(), m.end()) for m in re.finditer(r'\[(\w+)[^]]*\](.*?)\[/\1\]', text)]):\n            safe_index += 1\n        # Check if the index is inside any standalone BBCode\n        elif any(start <= safe_index < end for start, end in [(m.start(), m.end()) for m in re.finditer(r'\[(\w+)\|([^\]]+)\]', text)]):\n            safe_index += 1\n        else:\n            break\n\n    return safe_index