SELECT \n    cn AS GroupName,\n    distinguishedName\nFROM         OPENQUERY(ADSI, \n                      '\n select\n     cn,\n     distinguishedName\n from ''LDAP://DC=name,DC=local''\n where objectClass = ''group''\n order by cn\n ')\nAS derivedtbl_1