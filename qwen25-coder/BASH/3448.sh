#!/bin/bash\n\n# Define the directory containing your files\nDIR="path/to/your/files"\n\n# Loop over each file in the directory\nfor FILE in "$DIR"/*; do\n    # Check if it is a regular file\n    if [ -f "$FILE" ]; then\n        # Extract lines 6-15 from File B and store them in a temporary file\n        awk 'NR>=6&&NR<=15' FileB > temp.txt\n\n        # Replace lines 5-15 in the current file A with the content of temp.txt\n        sed -i.bak '5,15 {\n            r temp.txt\n            d\n        }' "$FILE"\n    fi\ndone\n\n# Remove the temporary file after processing all files\nrm temp.txt