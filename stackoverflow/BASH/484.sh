# repair pgp-encoded messages with missing Content-Type\n######################################################################\n\n:0\n* !^Content-Type: message/\n* !^Content-Type: multipart/\n* !^Content-Type: application/pgp\n{\n   :0 fBw\n   * ^-----BEGIN PGP MESSAGE-----\n   * ^-----END PGP MESSAGE-----\n   | /usr/bin/formail \\n       -i "Content-Type: application/pgp; format=text; x-action=encrypt"\n\n   :0 fBw\n   * ^-----BEGIN PGP SIGNED MESSAGE-----\n   * ^-----BEGIN PGP SIGNATURE-----\n   * ^-----END PGP SIGNATURE-----\n   | /usr/bin/formail \\n       -i "Content-Type: application/pgp; format=text; x-action=sign"\n}