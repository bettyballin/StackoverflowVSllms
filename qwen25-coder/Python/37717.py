def find_differences(file1, file2):\n    added = []\n    removed = []\n\n    with open(file1, 'r') as f1, open(file2, 'r') as f2:\n        line1 = f1.readline()\n        line2 = f2.readline()\n\n        while line1 or line2:\n            if line1 and not line2:\n                removed.append(line1)\n                line1 = f1.readline()\n            elif not line1 and line2:\n                added.append(line2)\n                line2 = f2.readline()\n            else:\n                # Both lines are present\n                if line1 < line2:\n                    removed.append(line1)\n                    line1 = f1.readline()\n                elif line1 > line2:\n                    added.append(line2)\n                    line2 = f2.readline()\n                else:\n                    # Both files have the same line, move forward in both\n                    line1 = f1.readline()\n                    line2 = f2.readline()\n\n    return added, removed\n\n# Usage example\nadded_files, removed_files = find_differences('file_snapshot_1.txt', 'file_snapshot_2.txt')\nprint("Added files:", added_files)\nprint("Removed files:", removed_files)