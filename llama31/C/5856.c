struct tm tm;\ntm.tm_year = 1969 - 1900; // pre-epoch year\ntm.tm_mon = 12 - 1; // December\ntm.tm_mday = 31;\ntm.tm_hour = 23;\ntm.tm_min = 59;\ntm.tm_sec = 59;\n\ntime_t seconds = seconds_to_date(&tm);