ldapadd -x -D "cn=admin,dc=example,dc=com" -w "admin_password" <<EOF\ndn: cn=john,dc=example,dc=com\nobjectClass: inetOrgPerson\ncn: john\nsn: Doe\nuserPassword: john_password\nEOF\n\nldapadd -x -D "cn=admin,dc=example,dc=com" -w "admin_password" <<EOF\ndn: cn=svn_users,dc=example,dc=com\nchangetype: modify\nadd: member\nmember: cn=john,dc=example,dc=com\nEOF