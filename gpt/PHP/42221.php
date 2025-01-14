// Example of adding an entry with a single structural objectClass\nldap_add($ldap, 'OU=Test,OU=Test,DC=domain,DC=example,DC=local', array(\n    'ou' => 'Test',\n    'objectClass' => array('top', 'organizationalUnit'),\n    'l' => 'location'\n));\n\n// Example of adding an entry with an auxiliary objectClass (if schema allows)\nldap_add($ldap, 'OU=Test,OU=Test,DC=domain,DC=example,DC=local', array(\n    'ou' => 'Test',\n    'associatedDomain' => 'domain',\n    'objectClass' => array('top', 'organizationalUnit', 'domainRelatedObject'),\n    'l' => 'location'\n));