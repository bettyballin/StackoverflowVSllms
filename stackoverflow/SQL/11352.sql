SELECT order_id,product_name,qty\nFROM orders\nWHERE foo = 'bar'\nINTO OUTFILE '/var/lib/mysql-files/orders.csv'\nFIELDS TERMINATED BY ','\nENCLOSED BY '"'\nLINES TERMINATED BY '\n';