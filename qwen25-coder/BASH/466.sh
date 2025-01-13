# Example of a pre-commit hook that checks for sensitive patterns\n   SENSITIVE_PATTERNS=("API_KEY" "PASSWORD")\n   if git grep -i "${SENSITIVE_PATTERNS[@]}" -- ':!*.log' ; then\n       echo "Sensitive data detected in files. Aborting commit."\n       exit 1\n   fi