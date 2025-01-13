#!/bin/bash\n     FILE_TO_ENCRYPT="/path/to/your/file"\n     COMPRESSED_FILE="/path/to/your/file.tar.gz"\n     ENCRYPTED_FILE="/path/to/your/file.tar.gz.gpg"\n     RECIPIENT="Recipient's Name"\n\n     # Compress the file\n     tar -czvf $COMPRESSED_FILE $FILE_TO_ENCRYPT\n\n     # Encrypt the compressed file\n     gpg --output $ENCRYPTED_FILE --encrypt --recipient "$RECIPIENT" $COMPRESSED_FILE