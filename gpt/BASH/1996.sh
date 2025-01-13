#!/bin/bash\n\n# Main script to turn off the internet\nmain_script() {\n  while true; do\n    echo "Disabling internet..."\n    sudo ifconfig en0 down\n    sleep 300  # Disable internet for 5 minutes\n    sudo ifconfig en0 up\n    sleep 600  # Enable internet for 10 minutes\n  done\n}\n\n# Watchdog script to monitor and restart the main script\nwatchdog_script() {\n  while true; do\n    if ! pgrep -f "my_productivity_script.sh" > /dev/null; then\n      ./my_productivity_script.sh &\n    fi\n    sleep 10\n  done\n}\n\n# Run the main script and the watchdog\nmain_script &\nwatchdog_script &