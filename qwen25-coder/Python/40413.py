import mysql.connector\n\n     # Connect to MySQL database with compression\n     db = mysql.connector.connect(host="localhost", user="youruser", passwd="yourpassword", db="yourdb",\n                                    use_compression=True)