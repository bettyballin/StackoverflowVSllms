from difflib import SequenceMatcher\n\ndef similarity(line1, line2):\n    return SequenceMatcher(None, line1, line2).ratio()\n\ndef find_notable_lines(lines, threshold=0.5):\n    notable_lines = set()\n    num_lines = len(lines)\n\n    for i in range(num_lines):\n        is_unique = True\n        for j in range(i + 1, num_lines):\n            if similarity(lines[i], lines[j]) >= threshold:\n                is_unique = False\n                break\n        if is_unique:\n            notable_lines.add(lines[i])\n\n    return list(notable_lines)\n\n# Example usage\nlog_file_path = 'your_log_file.log'\nwith open(log_file_path, 'r') as file:\n    log_lines = file.readlines()\n\nnotable_lines = find_notable_lines(log_lines)\nfor line in notable_lines:\n    print(line.strip())