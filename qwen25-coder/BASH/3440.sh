awk -F: '{split($5, fields, ","); for (i=1; i in fields; i++) if (fields[i] ~ /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/) print fields[i]}' /etc/passwd