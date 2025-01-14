import sqlite3\n\n# Connect to your SQLite database\nconn = sqlite3.connect('example.db')\ncursor = conn.cursor()\n\n# The search term you want to match within the title\nsearch_term = 'x'\n\n# Use parameterized query with the LIKE clause\nquery = "SELECT * FROM table WHERE title LIKE ?"\n\n# Bind the parameter with the wildcard characters\ncursor.execute(query, ('%' + search_term + '%',))\n\n# Fetch and process the results\nresults = cursor.fetchall()\nfor row in results:\n    print(row)\n\n# Close the connection\nconn.close()