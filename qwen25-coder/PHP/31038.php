function IsAuthorized($user, $resource) {\n    // Example caching mechanism using PHP session (ensure proper session handling)\n    if (!isset($_SESSION['permissions'])) {\n        $_SESSION['permissions'] = getUserPermissionsFromAD($user);\n    }\n\n    return in_array($resource, $_SESSION['permissions']);\n}\n\nfunction getUserPermissionsFromAD($user) {\n    $ldapConnection = ldap_connect("your_ldap_server");\n    ldap_set_option($ldapConnection, LDAP_OPT_PROTOCOL_VERSION, 3); // Important for security\n    if (ldap_bind($ldapConnection)) { // Bind with appropriate credentials\n        $result = ldap_search($ldapConnection, "dc=example,dc=com", "(sAMAccountName=$user)", array('memberOFGROUP'));\n        $entries = ldap_get_entries($ldapConnection, $result);\n        ldap_unbind($ldapConnection);\n\n        // Process entries to extract group names or use as permissions\n        return processEntriesForPermissions($entries);\n    }\n\n    return [];\n}\n\nfunction processEntriesForPermissions($entries) {\n    // Dummy function logic - implement according to AD structure and requirements\n    $permissions = [];\n    foreach ($entries as $entry) {\n        if (isset($entry['memberof'])) {\n            foreach ($entry['memberof'] as $group) {\n                // Extract group name from distinguished name and add to permissions\n                preg_match('/CN=([^,]+)/i', $group, $matches);\n                if (!empty($matches[1])) {\n                    $permissions[] = strtolower($matches[1]);\n                }\n            }\n        }\n    }\n    return array_unique($permissions);\n}\n\n// Usage example\nif (IsAuthorized("username", "personnel_payroll")) {\n    // Access granted to personnel_payroll.php\n}