SSL_CTX* ctx = SSL_CTX_new(TLS_client_method());\nif (SSL_CTX_load_verify_locations(ctx, "ca.crt", NULL) <= 0) {\n    // handle error\n}