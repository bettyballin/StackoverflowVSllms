<?php\n/* Servers configuration */\n$i = 0;\n\n$i++;\n/* Server: MySQL [1] */\n$cfg['Servers'][$i]['auth_type'] = 'cookie';\n$cfg['Servers'][$i]['host'] = 'your_mysql_server_host';\n$cfg['Servers'][$i]['user'] = 'your_mysql_user';\n$cfg['Servers'][$i]['password'] = 'your_mysql_password';\n$cfg['Servers'][$i]['connect_type'] = 'tcp';\n$cfg['Servers'][$i]['AllowNoPassword'] = false;\n$cfg['Servers'][$i]['ssl'] = true;\n$cfg['Servers'][$i]['ssl_key'] = '/path/to/client-key.pem';\n$cfg['Servers'][$i]['ssl_cert'] = '/path/to/client-cert.pem';\n$cfg['Servers'][$i]['ssl_ca'] = '/path/to/ca-cert.pem';\n\n/* End of servers configuration */\n?>