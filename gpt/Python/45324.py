import difflib\nimport itertools\n\ndef compute_similarity(line1, line2):\n    return difflib.SequenceMatcher(None, line1, line2).ratio()\n\ndef find_distinct_lines(logfile, threshold=0.5):\n    with open(logfile, 'r') as f:\n        lines = f.readlines()\n    \n    distinct_lines = []\n    \n    for line in lines:\n        is_distinct = True\n        for other_line in distinct_lines:\n            if compute_similarity(line, other_line) > threshold:\n                is_distinct = False\n                break\n        if is_distinct:\n            distinct_lines.append(line)\n    \n    return distinct_lines\n\n# Example usage\nlogfile = 'webapp.log'\nthreshold = 0.5\ndistinct_lines = find_distinct_lines(logfile, threshold)\n\nfor line in distinct_lines:\n    print(line.strip())