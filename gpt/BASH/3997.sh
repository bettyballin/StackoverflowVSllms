#!/bin/sh\n   if grep -q "password" "$@"; then\n       echo "Error: Commit contains the forbidden string 'password'."\n       exit 1\n   fi