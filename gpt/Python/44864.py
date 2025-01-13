import mysql.connector\n\n# Establish the connection\nconn = mysql.connector.connect(\n    host="your_host",\n    user="your_user",\n    password="your_password",\n    database="your_database"\n)\n\n# Prepare a cursor object\ncursor = conn.cursor()\n\n# User input (make sure to validate and sanitize this in a real application)\nartist_name = input("Enter artist name: ")\n\n# Prepare the query\nquery = """\nSELECT e.*\nFROM artist a\nJOIN events e ON a.id = e.artist_id\nWHERE a.name = %s;\n"""\n\n# Execute the query\ncursor.execute(query, (artist_name,))\n\n# Fetch and display results\nfor (id, artist_id, venue_name, city, state, date, time) in cursor:\n    print(f"ID: {id}, Artist ID: {artist_id}, Venue: {venue_name}, City: {city}, State: {state}, Date: {date}, Time: {time}")\n\n# Close the cursor and connection\ncursor.close()\nconn.close()