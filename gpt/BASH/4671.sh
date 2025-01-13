fn_exists() {\n    declare -F "$1" > /dev/null 2>&1\n    return $?\n}\n\n# Usage example\nif fn_exists "init"; then\n    echo "init function exists"\nelse\n    echo "init function does not exist"\nfi\n\nif fn_exists "execute"; then\n    echo "execute function exists"\nelse\n    echo "execute function does not exist"\nfi\n\nif fn_exists "cleanup"; then\n    echo "cleanup function exists"\nelse\n    echo "cleanup function does not exist"\nfi