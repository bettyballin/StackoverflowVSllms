MY_SMTP_SETTINGS = {\n     :address              => 'oz.some.server.edu',\n     :port                 => 465,\n     :user_name            => MY_USERNAME,\n     :password             => MY_PASSWORD,\n     :authentication       => :login,        # or :plain, :cram_md5, etc.\n     :enable_starttls_auto => true,          # This is important for secure connections\n     :ssl                  => true,          # Enable SSL for port 465\n     :tls                  => true           # Enable TLS\n   }