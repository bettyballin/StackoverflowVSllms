WITH total_events AS (\n    -- Your complex query goes here\n    @total@\n)\nSELECT \n    (SELECT COUNT(*) FROM total_events WHERE @conditions@) AS suboccurs,\n    (SELECT COUNT(*) FROM total_events) AS totaloccurs;