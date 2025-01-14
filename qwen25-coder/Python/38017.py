def char_by_char_diff(line1, line2):\n    # Find the longest line length\n    max_length = max(len(line1), len(line2))\n    diff = ''\n    \n    for i in range(max_length):\n        try:\n            if line1[i] == line2[i]:\n                diff += ' '\n            else:\n                diff += '^'\n        except IndexError:\n            diff += '+'\n    \n    return diff\n\ndef compare_files(file1, file2):\n    with open(file1, 'r') as f1, open(file2, 'r') as f2:\n        lines1 = f1.readlines()\n        lines2 = f2.readlines()\n\n        max_length = max(len(lines1), len(lines2))\n        \n        for i in range(max_length):\n            line1 = lines1[i].rstrip('\n') if i < len(lines1) else ''\n            line2 = lines2[i].rstrip('\n') if i < len(lines2) else ''\n\n            if line1 != line2:\n                print(f"Line {i+1} differs:")\n                print(">", line1)\n                print("<", line2)\n                diff_line = char_by_char_diff(line1, line2)\n                if diff_line.strip():\n                    print(" ", diff_line)\n\n# Usage\ncompare_files('file1.txt', 'file2.txt')