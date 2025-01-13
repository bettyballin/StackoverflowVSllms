#!/bin/bash\n\n# Path to your LaunchAgent plist file\nPLIST_PATH="/Library/LaunchAgents/com.mycompany.mydaemon.plist"\n\n# Function to load or unload the LaunchAgent\ncontrol_launchagent() {\n    local action=$1\n    local plist=$2\n    for pid in $(pgrep -x launchd); do\n        if [ "$pid" -ne 1 ]; then\n            sudo launchctl bsexec $pid launchctl $action -S Aqua $plist\n        fi\n    done\n}\n\n# Check for script arguments (load or unload)\nif [ "$#" -ne 1 ]; then\n    echo "Usage: $0 <load|unload>"\n    exit 1\nfi\n\n# Call the control function with the specified action\ncase $1 in\n    load)\n        control_launchagent "load" $PLIST_PATH\n        ;;\n    unload)\n        control_launchagent "unload" $PLIST_PATH\n        ;;\n    *)\n        echo "Invalid action: $1"\n        echo "Usage: $0 <load|unload>"\n        exit 1\n        ;;\nesac