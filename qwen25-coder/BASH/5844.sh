#!/bin/bash\n\n# Get all .jpg files sorted by name\nshopt -s nullglob\nfiles=(*.jpg)\nshopt -u nullglob\n\ncount=1\n\nfor file in "${files[@]}"; do\n  new_name=$(printf "image_%03d.jpg" "$count")\n  mv -- "$file" "$new_name"\n  ((count++))\ndone