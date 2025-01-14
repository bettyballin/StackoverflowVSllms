function canAccess($requiredRole) {\n    global $user; // Assume $user is the logged-in user object with role field\n    return ($user->role & $requiredRole) === $requiredRole;\n}\n\n// Example usage\nif (canAccess(ROLE_CLIENT_MANAGEMENT)) {\n    echo "You can access Client Management.";\n} else {\n    echo "Access denied to Client Management.";\n}