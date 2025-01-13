#!/bin/bash\n\n# Define the start and end patterns\nSTART_PATTERN="*** Start"\nEND_PATTERN="*** Finish"\n\n# Loop through all files in the directory\nfor file in *; do\n  # Skip directories, process only files\n  if [ -f "$file" ]; then\n    awk "/$START_PATTERN/{flag=1; next} /$END_PATTERN/{flag=0; next} flag" "$file" > temp && mv temp "$file"\n  fi\ndone