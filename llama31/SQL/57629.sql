CREATE EVENT archive_data\nON SCHEDULE EVERY 7 DAY\nDO\nCALL archive_data();