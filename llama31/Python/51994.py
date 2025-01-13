import oracle_sql_developer\n\n# Create a connection to the Oracle database\nconn = oracle_sql_developer.connect("username/password@host:port/SID")\n\n# Retrieve the XML data from the database\nxml_data = conn.execute("SELECT xml_column FROM my_table WHERE id = 1").fetchone()[0]\n\n# Get the XML data as a string\nxml_string = xml_data.getvalue()\n\n# Parse the XML data\nroot = ET.fromstring(xml_string)\n\n# Print the XML data\nprint(ET.tostring(root, encoding="unicode"))\n\n# Close the connection\nconn.close()