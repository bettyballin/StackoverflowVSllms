CREATE TABLE Revisions (\n      id INTEGER PRIMARY KEY,\n      message_id INTEGER,\n      revision_number INTEGER,\n      content TEXT,\n      created_at TIMESTAMP\n  );