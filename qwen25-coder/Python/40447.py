# Assuming results is the list of users retrieved from the LDAP query\nfiltered_results = [user for user in results if not user.distinguishedName.startswith('cn=,ou=Primary OU,dc=example,dc=com')]