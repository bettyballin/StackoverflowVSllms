require 'digest'\n\ndef generate_md5(input)\n  Digest::MD5.hexdigest(input)\nend\n\ninput_string = "Hello, World!"\nmd5_hash = generate_md5(input_string)\n\nputs "MD5 Hash: #{md5_hash}"