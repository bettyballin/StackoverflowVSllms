mysql -s -u [username] -p[password] [database] -e "SELECT * FROM [table]" | sed 's/\t/,/g'