CREATE USER 'replication_user'@'%' IDENTIFIED BY 'replication_password';\nGRANT REPLICATION SLAVE ON *.* TO 'replication_user'@'%';