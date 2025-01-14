def compare_files(file1_path, file2_path):\n    with open(file1_path, 'r') as file1, open(file2_path, 'r') as file2:\n        lines1 = file1.readlines()\n        lines2 = file2.readlines()\n\n    i, j = 0, 0\n    added = []\n    deleted = []\n\n    while i < len(lines1) and j < len(lines2):\n        if lines1[i] == lines2[j]:\n            i += 1\n            j += 1\n        elif lines1[i] not in lines2[j:]:\n            deleted.append(lines1[i].strip())\n            i += 1\n        elif lines2[j] not in lines1[i:]:\n            added.append(lines2[j].strip())\n            j += 1\n\n    while i < len(lines1):\n        deleted.append(lines1[i].strip())\n        i += 1\n\n    while j < len(lines2):\n        added.append(lines2[j].strip())\n        j += 1\n\n    return added, deleted\n\nfile1_path = 'snapshot1.txt'\nfile2_path = 'snapshot2.txt'\n\nadded, deleted = compare_files(file1_path, file2_path)\n\nprint("Added files:")\nfor file in added:\n    print(file)\n\nprint("\nDeleted files:")\nfor file in deleted:\n    print(file)