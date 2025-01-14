require 'rubygems'\nrequire 'crypt/blowfish'\n\nplain = "This is the plain text"\nputs plain\n\n# Ensure the plaintext length is a multiple of the block size (8 bytes for Blowfish)\npadded_plain = (plain + "\0" * 7)[0, (plain.length + 7) & ~7]\n\nblowfish = Crypt::Blowfish.new("A key up to 56 bytes long")\nenc = blowfish.encrypt_block(padded_plain)\n\n# Convert the encrypted binary string to a hexadecimal ASCII string\nhex_enc = enc.unpack("H*").first\nputs hex_enc