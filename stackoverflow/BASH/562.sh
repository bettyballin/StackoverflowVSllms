#!/bin/bash\n\necho "Enter PID to search: "\nread PID\nsearch=$(ps --pid $PID -o comm=)\n\nif [ $search ]\n    then\n        echo "Program: $search"\n    else\n        echo "No program found with PID: $PID"\nfi