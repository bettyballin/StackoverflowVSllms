ldap_add($ldap, 'OU=Test,OU=Test,DC=domain,DC=example,DC=local', array(\n    'ou' => 'Test',\n    'associatedDomain' => 'domain',\n    'objectClass' => array('organizationalUnit', 'domainRelatedObject'),\n    'l' => 'location'\n));