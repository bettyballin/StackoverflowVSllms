kadmin: addprinc -randkey HTTP/yourserver.example.com@YOUR.REALM\nkadmin: xst -norandkey -k /etc/apache2/http.keytab HTTP/yourserver.example.com@YOUR.REALM