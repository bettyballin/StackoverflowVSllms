SELECT i.*, s.Face_value\nFROM Item i\nJOIN Event e ON i.Event_id = e.Id\nJOIN Seat s ON e.Venue_id = s.Venue_id AND e.Configuration = s.Configuration AND i.Section = s.Section;