#!/bin/bash\n\nfor file in *.txt; do\n  new_name=$(echo "$file" | sed -e 's/\b\(.\)/\u\1/g')\n  svn mv "$file" "$new_name"\ndone\n\nsvn commit -m "caps"