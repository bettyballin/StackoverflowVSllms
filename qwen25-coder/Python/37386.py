# Define the sizes of our DMG files in MB\nfile_sizes = {\n    'Desktop2.dmg': 1026,\n    'CS_pdfs.dmg': 5078,\n    'Signal.dmg': 2097,\n    'things.dmg': 205,\n    'work.dmg': 205,\n    'fun.dmg': 1026,\n    'school.dmg': 1026,\n    'misc.dmg': 1026,\n    'something.dmg': 5078\n}\n\n# Define the capacity of a DVD in MB (4.7GB)\ndvd_capacity = 4700\n\n# First-fit decreasing algorithm implementation\ndef first_fit_decreasing(file_sizes, dvd_capacity):\n    # Sort files by size in descending order\n    sorted_files = sorted(file_sizes.items(), key=lambda x: -x[1])\n    \n    # Initialize list to hold DVDs (each DVD is a list of file names)\n    dvds = []\n    \n    for file_name, file_size in sorted_files:\n        placed = False\n        \n        for dvd in dvds:\n            if sum(map(lambda f: file_sizes[f], dvd)) + file_size <= dvd_capacity:\n                # If there's room on this DVD, add the file to it\n                dvd.append(file_name)\n                placed = True\n                break\n        \n        if not placed:\n            # If no space was found in existing DVDs, create a new DVD with that single file\n            dvds.append([file_name])\n    \n    return dvds\n\n# Find the optimal distribution of files across DVDs using FFD\ndvd_distribution = first_fit_decreasing(file_sizes, dvd_capacity)\n\n# Print out the result\nfor i, dvd in enumerate(dvd_distribution):\n    print(f"DVD {i+1}: {', '.join([f'{file} ({file_sizes[file]} MB)' for file in dvd])}")