#!/bin/bash\n# save this as diffclean.sh and make executable with: chmod +x diffclean.sh\n\ndiff -ruN -x "*~" -x "*.bak" "$@"