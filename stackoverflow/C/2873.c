struct tm tm;\ntime_t epoch;\nif ( strptime(timestamp, "%Y-%m-%d %H:%M:%S", &tm) != NULL )\n  epoch = mktime(&tm);\nelse\n  // badness