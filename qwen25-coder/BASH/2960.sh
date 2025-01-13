echo -n "Enter a string here: "\nread -e STRING\n\n# Sanitize input:\n# 1. Convert to lowercase\n# 2. Remove non-alphanumeric characters except spaces\n# 3. Replace spaces with underscores\nSANITIZED_STRING=$(echo "$STRING" | tr '[:upper:]' '[:lower:]' | sed 's/[^a-z0-9 ]//g' | tr ' ' '_')\n\necho "Sanitized string: $SANITIZED_STRING"