#!/bin/bash\n\nruns=10\nphp_script="your_script.php"\npython_script="your_script.py"\nphp_total=0\npython_total=0\n\nfor ((i=1; i<=runs; i++)); do\n    php_time=$( (time php $php_script) 2>&1 | grep real | awk '{print $2}')\n    python_time=$( (time python $python_script) 2>&1 | grep real | awk '{print $2}')\n    \n    php_total=$(echo $php_total + $php_time | bc)\n    python_total=$(echo $python_total + $python_time | bc)\ndone\n\nphp_average=$(echo "scale=3; $php_total / $runs" | bc)\npython_average=$(echo "scale=3; $python_total / $runs" | bc)\n\necho "Average PHP time: $php_average seconds"\necho "Average Python time: $python_average seconds"