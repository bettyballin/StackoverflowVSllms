timestamp=$(stat -c "%y-%m-%d %H:%M:%S %N" timestamp-file)\nfor file in *; do\n  file_timestamp=$(stat -c "%y-%m-%d %H:%M:%S %N" "$file")\n  if [ "$file_timestamp" \> "$timestamp" ]; then\n    echo "$file"\n  fi\ndone