import uuid\n\ndef generate_session_id():\n    return str(uuid.uuid4())\n\nsession_id = generate_session_id()\nprint(session_id)