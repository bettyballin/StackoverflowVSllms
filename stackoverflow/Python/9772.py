>>> s = '\u003cfoo/\u003e'\n>>> s.decode( 'unicode-escape' )\nu'<foo/>'\n>>> s.decode( 'unicode-escape' ).encode( 'ascii' )\n'<foo/>'