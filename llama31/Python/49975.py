import magic\n\nmime_type = magic.from_file(nomeFile, mime=True)\n\nif mime_type in ('image/jpeg', 'image/png', 'application/pdf', ...):\n    # File type is acceptable\nelse:\n    # File type is not acceptable