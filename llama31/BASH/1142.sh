status_code=$(grep -oE 'return status = [0-9]+' $test | cut -d' ' -f4)