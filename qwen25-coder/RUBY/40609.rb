require 'openssl'\nrequire 'base64'\n\ndef encrypt(data, key_base64, iv_base64)\n  # Decode base64 key and IV\n  key = Base64.decode64(key_base64)\n  iv = Base64.decode64(iv_base64)\n\n  # Create AES cipher object\n  cipher = OpenSSL::Cipher.new('aes-256-cbc')\n  cipher.encrypt\n  cipher.key = key\n  cipher.iv = iv\n\n  encrypted_data = cipher.update(data) + cipher.final\n  Base64.encode64(encrypted_data)\nend\n\n# Example usage\nkey_base64 = '0123456789abcdef0123456789abcdef' # Must be 32 bytes for AES-256\niv_base64 = 'abcdef9876543210' # Must be 16 bytes for AES-256-CBC\ndata_to_encrypt = 'Hello, World!'\n\nputs "Encrypted data: #{encrypt(data_to_encrypt, key_base64, iv_base64)}"