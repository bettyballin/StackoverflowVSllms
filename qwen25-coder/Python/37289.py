import sqlite3  # or any other database connector\n\ndef load_labels_from_db(db_path):\n    conn = sqlite3.connect(db_path)\n    cursor = conn.cursor()\n    cursor.execute("SELECT db_field_name, gui_label FROM field_label_mapping")\n    labels = {row[0]: row[1] for row in cursor.fetchall()}\n    conn.close()\n    return labels\n\nlabels = load_labels_from_db('database.db')\nprint(labels)