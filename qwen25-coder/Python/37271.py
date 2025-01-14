import sqlite3\nfrom datetime import datetime\nimport pytz\n\ndef convert_to_cst(utc_dt_str):\n    utc = pytz.utc\n    central = pytz.timezone('US/Central')\n    utc_dt = utc.localize(datetime.strptime(utc_dt_str, '%Y-%m-%d %H:%M:%S'))\n    return utc_dt.astimezone(central).strftime('%Y-%m-%d %H:%M:%S')\n\n# Connect to SQLite database\nconn = sqlite3.connect('your_database.db')\nconn.create_function("convert_to_cst", 1, convert_to_cst)\n\n# Query using the custom function\ncursor = conn.execute("SELECT timestamp, convert_to_cst(timestamp) AS cst_time FROM your_table_name")\nrows = cursor.fetchall()\n\nfor row in rows:\n    print(row)\n\nconn.close()