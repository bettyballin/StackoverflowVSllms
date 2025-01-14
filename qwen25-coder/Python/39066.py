from OpenSSL import SSL, crypto\n\ndef verify_callback(connection, x509, errnum, errdepth, ok):\n    print "Certificate:", x509.get_subject()\n    return ok\n\ncontext = SSL.Context(SSL.SSLv23_METHOD)\ncontext.set_default_verify_paths()\n\n# Set the verification mode\ncontext.set_verify(SSL.VERIFY_PEER, verify_callback)\n\n# Create a connection using the context\ndef create_ssl_connection(host, port):\n    sock = SSL.Connection(context, socket.socket(socket.AF_INET))\n    try:\n        print "Connecting to %s:%d..." % (host, port)\n        sock.connect((host, port))\n        print "Connection established successfully."\n        # Perform secure operations here...\n    except Exception as e:\n        print("Error:", e)\n    finally:\n        sock.close()\n\ncreate_ssl_connection('example.com', 443)