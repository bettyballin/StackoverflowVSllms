#!/bin/bash\n\n# Ensure hostname is provided as an argument\nif [ -z "$1" ]; then\n  echo "Usage: $0 <hostname>"\n  exit 1\nfi\n\n# SSH into the host and start a python shell\nssh -t $1 /usr/bin/python3