def find_differences(file1, file2):\n    added = []\n    removed = []\n    \n    with open(file1, 'r') as f1, open(file2, 'r') as f2:\n        lines1 = list(f1)\n        lines2 = list(f2)\n\n    i, j = 0, 0\n    m, n = len(lines1), len(lines2)\n\n    while i < m or j < n:\n        if i == m:\n            # If file1 is exhausted, all remaining lines in file2 are added\n            added.extend(lines2[j:])\n            break\n        elif j == n:\n            # If file2 is exhausted, all remaining lines in file1 are removed\n            removed.extend(lines1[i:])\n            break\n        \n        if lines1[i] < lines2[j]:\n            removed.append(lines1[i])\n            i += 1\n        elif lines1[i] > lines2[j]:\n            added.append(lines2[j])\n            j += 1\n        else:\n            # Both files have the same line, move forward in both\n            i += 1\n            j += 1\n\n    return added, removed\n\n# Usage example\nadded_files, removed_files = find_differences('file_snapshot_1.txt', 'file_snapshot_2.txt')\nprint("Added files:", added_files)\nprint("Removed files:", removed_files)