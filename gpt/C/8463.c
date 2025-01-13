const char *sql = \n    "SELECT *, rowid "\n    "FROM tblEvent_basic "\n    "WHERE service_id = ? AND ("\n    "    (start_time >= ? AND start_time <= ?) OR "\n    "    (end_time > ? AND end_time < ?) OR "\n    "    (start_time < ? AND end_time > ?) "\n    ") "\n    "ORDER BY start_time ASC";