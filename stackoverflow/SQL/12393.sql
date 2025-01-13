CREATE TABLE users (\n  user_id               INTEGER,\n  authentication_hash   BINARY,\n  authentication_salt   BINARY,\n  public_key            BINARY,\n  encrypted_private_key BINARY,\n  decryption_key_salt   BINARY,\n  PRIMARY KEY(user_id)\n)\n\nCREATE TABLE secrets (\n    secret_id INTEGER,\n    -- WHATEVER COLUMNS YOU REQUIRE TO ACCURATELY MODEL YOUR PASSWORDS (CLIENT INFO, ETC)\n    PRIMARY KEY(secret_id)\n)\n\nCREATE TABLE granted_secrets (\n  secret_id      INTEGER,\n  recipient_id   INTEGER,\n  encrypted_data BINARY,\n  PRIMARY KEY(secret_id, recipient_id),\n  FOREIGN KEY(secret_id) REFERENCES secrets(secret_id)\n  FOREIGN KEY(recipient_id) REFERENCES users(user_id)\n)