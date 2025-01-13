import sqlite3\n\n    # Connect to the SQLite database (or create it if it doesn't exist)\n    conn = sqlite3.connect('rss_reader.db')\n\n    # Create a cursor object to interact with the database\n    cursor = conn.cursor()\n\n    # Create a table to store URLs\n    cursor.execute('''\n    CREATE TABLE IF NOT EXISTS urls (\n        id INTEGER PRIMARY KEY AUTOINCREMENT,\n        url TEXT NOT NULL,\n        description TEXT\n    )\n    ''')\n\n    # Commit the transaction\n    conn.commit()\n\n    # Close the connection\n    conn.close()