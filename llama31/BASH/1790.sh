#!/usr/bin/expect -f\n\nset timeout -1\nset password "p@ssword"\n\nspawn ssh me@127.0.0.1\n\nexpect "password: "\nsend -- "$password\r"\n\ninteract