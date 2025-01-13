from sshtunnel import SSHTunnelForwarder\nimport MySQLdb\n\n# Define your proxy and MySQL server details\nproxy_host = 'your.proxy.host'\nproxy_port = 22  # SSH port, usually 22\nmysql_host = 'your.mysql.server'\nmysql_port = 3306  # MySQL default port\nmysql_user = 'your_mysql_user'\nmysql_password = 'your_mysql_password'\nmysql_db = 'your_database'\n\n# Create an SSH tunnel\nwith SSHTunnelForwarder(\n    (proxy_host, proxy_port),\n    ssh_username='your_ssh_username',\n    ssh_password='your_ssh_password',\n    remote_bind_address=(mysql_host, mysql_port)\n) as tunnel:\n    conn = MySQLdb.connect(\n        host='127.0.0.1',\n        port=tunnel.local_bind_port,\n        user=mysql_user,\n        passwd=mysql_password,\n        db=mysql_db\n    )\n    \n    # Use the connection\n    cursor = conn.cursor()\n    cursor.execute("SELECT VERSION()")\n    data = cursor.fetchone()\n    print("Database version : %s " % data)\n    \n    # Close the connection\n    cursor.close()\n    conn.close()