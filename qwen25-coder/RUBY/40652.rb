require 'openssl'\nrequire 'base64'\n\nmodule MySqlAESCompatibility\n  def self.aes_encrypt(plain_text, key)\n    # Truncate or pad the key to exactly 16 bytes for AES-128\n    adjusted_key = key[0, 16].ljust(16, "\x00")\n\n    cipher = OpenSSL::Cipher.new("AES-128-ECB")\n    cipher.encrypt\n    cipher.key = adjusted_key\n\n    encrypted = cipher.update(plain_text) + cipher.final\n    # To store or display it in a way similar to MySQL\n    Base64.encode64(encrypted).strip\n  end\n\n  def self.aes_decrypt(encrypted_text, key)\n    decoded_encrypted_text = Base64.decode64(encrypted_text)\n\n    # Truncate or pad the key to exactly 16 bytes for AES-128\n    adjusted_key = key[0, 16].ljust(16, "\x00")\n\n    cipher = OpenSSL::Cipher.new("AES-128-ECB")\n    cipher.decrypt\n    cipher.key = adjusted_key\n\n    decrypted = cipher.update(decoded_encrypted_text) + cipher.final\n    decrypted.strip\n  end\nend\n\n# Usage example:\nplain_password = "password"\nkey = "82pjd12398JKBSDIGUSisahdoahOUASDHsdapdjqwjeASIduAsdh078asdASD087asdADSsdjhA7809asdajhADSs"\n\nencrypted_password = MySqlAESCompatibility.aes_encrypt(plain_password, key)\nputs "Encrypted Password: #{encrypted_password}"\n\ndecrypted_password = MySqlAESCompatibility.aes_decrypt(encrypted_password, key)\nputs "Decrypted Password: #{decrypted_password}"