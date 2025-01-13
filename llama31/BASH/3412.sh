#!/bin/bash\n\nphp_time=0\npython_time=0\niterations=10\n\nfor ((i=0; i<iterations; i++)); do\n  php_time=$(echo "$php_time + $(time php your_script.php | grep real | awk '{print $2}')" | bc)\n  python_time=$(echo "$python_time + $(time python your_script.py | grep real | awk '{print $2}')" | bc)\ndone\n\nphp_avg_time=$(echo "scale=3; $php_time / $iterations" | bc)\npython_avg_time=$(echo "scale=3; $python_time / $iterations" | bc)\n\necho "PHP average time: $php_avg_time seconds"\necho "Python average time: $python_avg_time seconds"