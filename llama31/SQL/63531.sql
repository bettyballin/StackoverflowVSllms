CREATE USER 'newadmin'@'%' IDENTIFIED BY 'strong_password';\nGRANT ALL PRIVILEGES ON *.* TO 'newadmin'@'%';\nFLUSH PRIVILEGES;