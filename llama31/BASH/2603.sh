array=()\nwhile IFS= read -r -d '' file; do\n  array+=("$file")\ndone < <(find . -print0)\necho ${#array[@]}