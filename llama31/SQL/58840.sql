CREATE VIEW events_with_milliseconds AS\nSELECT event_time + (event_milliseconds / 1000) AS event_time\nFROM events;