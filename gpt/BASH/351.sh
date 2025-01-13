#!/bin/bash\nREPOS="$1"\nREV="$2"\n\n# Directory containing the wiki pages\nPAGES_DIR="/path/to/pages"\n\n# Reset permissions and ownership\nchown -R www-data:www-data "$PAGES_DIR"\nchmod -R 664 "$PAGES_DIR"\nfind "$PAGES_DIR" -type d -exec chmod 775 {} \;