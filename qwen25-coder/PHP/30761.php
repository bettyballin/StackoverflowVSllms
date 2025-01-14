<?php\n$ldapserver = 'your-ldap-server.example.com';\n$dn        = "uid=" . $username . ",ou=users,dc=example,dc=com";\n$password  = $userPassword;\n\n// Connecting to ldap server\n$ldapconn = ldap_connect($ldapserver);\nif ($ldapconn) {\n    // Binding to ldap server\n    if (ldap_bind($ldapconn, $dn, $password)) {\n        echo "LDAP bind successful...";\n    } else {\n        echo "LDAP bind failed... ";\n    }\n} else {\n    die("Couldn't connect to LDAP server.");\n}\n?>