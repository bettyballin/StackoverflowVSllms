with open('your_file.txt', 'r') as f:\n    lines = [line.strip() for line in f if line.strip()]\n\nheading = lines[0]\ncolumns = lines[1].split()\n\n# Remove newline character from last column\nlast_column = columns[-1].rstrip('\n')\n\nprint("Heading:", heading)\nprint("Columns:", columns)\nprint("Last Column:", last_column)