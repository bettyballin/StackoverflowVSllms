mysql -u uid -ppwd -D dbname --batch --silent -e "SELECT id, name FROM students" | sed 's/\t/,/g' > list.csv