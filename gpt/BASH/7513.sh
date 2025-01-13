#!/bin/bash\n\n# Initialize a counter\ncounter=1\n\n# Iterate over the list of jpg files in sorted order\nfor file in $(ls *.jpg | sort); do\n    # Format the new filename with leading zeros\n    new_name=$(printf "image_%03d.jpg" $counter)\n    \n    # Rename the file\n    mv "$file" "$new_name"\n    \n    # Increment the counter\n    counter=$((counter + 1))\ndone