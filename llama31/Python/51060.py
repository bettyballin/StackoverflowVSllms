import datetime\n\ncursor.execute("SELECT WhenAdded FROM Log")\nresults = cursor.fetchall()\nfor row in results:\n    timestamp = row[0]\n    dt = datetime.datetime.strptime(timestamp, '%Y-%m-%d %H:%M:%S.%f %z')\n    print(dt)