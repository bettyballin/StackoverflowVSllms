placeholder= '?' # For SQLite. See DBAPI paramstyle.\nplaceholders= ', '.join(placeholder for unused in l)\nquery= 'SELECT name FROM students WHERE id IN (%s)' % placeholders\ncursor.execute(query, l)