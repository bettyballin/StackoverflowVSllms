# On the live server (master)\nmysql> GRANT REPLICATION SLAVE ON *.* TO 'replication_user'@'%' IDENTIFIED BY 'password';\n\n# On the backup server (slave)\nmysql> CHANGE MASTER TO MASTER_HOST='live_server_ip', MASTER_PORT=3306, MASTER_USER='replication_user', MASTER_PASSWORD='password';\nmysql> START SLAVE;