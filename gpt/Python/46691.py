from collections import defaultdict\n\ndupe = [\n    ['95d1543adea47e88923c3d4ad56e9f65c2b40c76', 'ron\\c', 'apa.txt'],\n    ['95d1543adea47e88923c3d4ad56e9f65c2b40c76', 'ron\\c', 'knark.txt'],\n    ['b5cc17d3a35877ca8b76f0b2e07497039c250696', 'ron\\a', 'apa2.txt'],\n    ['b5cc17d3a35877ca8b76f0b2e07497039c250696', 'ron\\a', 'jude.txt']\n]\n\ngrouped_dupes = defaultdict(list)\n\n# Group the items by the first two elements\nfor item in dupe:\n    key = (item[0], item[1])\n    grouped_dupes[key].append(item[2])\n\n# Write to the file\nwith open("dupe.txt", "w") as file:\n    for key, files in grouped_dupes.items():\n        file.write(f"{key[0]} {key[1]} {', '.join(files)}\n")