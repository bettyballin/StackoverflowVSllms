find . \( -name "*.jpg" -o -name "*.gif" \) -prune -o -type f -exec grep -s "B206" {} + -print