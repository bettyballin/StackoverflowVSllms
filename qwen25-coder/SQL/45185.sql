WITH total_events AS (\n    @total@\n)\nSELECT \n    COUNT(*) FILTER (WHERE @conditions@) AS suboccurs,\n    COUNT(*) AS totaloccurs\nFROM \n    total_events;