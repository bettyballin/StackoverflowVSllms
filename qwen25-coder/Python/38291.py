import sqlite3\n\ndef insert_test_data():\n    # Connect to your database\n    conn = sqlite3.connect('your_database.db')\n    cursor = conn.cursor()\n    \n    # Example data insertion\n    cursor.execute('''INSERT INTO users (name, email) VALUES (?, ?)''', ('Test User', 'test@example.com'))\n    \n    # Commit changes and close connection\n    conn.commit()\n    conn.close()\n\nif __name__ == "__main__":\n    insert_test_data()