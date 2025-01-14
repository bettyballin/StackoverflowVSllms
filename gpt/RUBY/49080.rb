require 'rubygems'\nrequire 'crypt/blowfish'\n\nplain = "This is the plain text"\nputs plain\n\nblowfish = Crypt::Blowfish.new("A key up to 56 bytes long")\nenc = blowfish.encrypt_block(plain)\n\n# Convert the encrypted binary string to a hexadecimal string\nhex_enc = enc.unpack1('H*')\nputs hex_enc