# Install necessary packages\nsudo yum install -y gcc zlib-devel openssl-devel readline-devel\n\n# To install Ruby 1.8.7 from source if no other options are available\nwget http://ftp.ruby-lang.org/pub/ruby/1.8/ruby-1.8.7-p374.tar.gz\ntar -xzvf ruby-1.8.7-p374.tar.gz\ncd ruby-1.8.7-p374/\n./configure --prefix=/usr/local/ruby\nmake\nsudo make install\n\n# Alternatively, use RVM or rbenv to manage Ruby versions easily