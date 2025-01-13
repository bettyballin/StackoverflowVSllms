#!/bin/bash\n\n# Monitor systemd user sessions\nloginctl monitor --json=short-pretty | while read -r event; do\n    if echo "$event" | grep -q 'UserNew'; then\n        echo "A new user started a session."\n    elif echo "$event" | grep -q 'UserRemoved'; then\n        echo "User session ended."\n    fi\ndone