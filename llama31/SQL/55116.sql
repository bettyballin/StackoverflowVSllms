SELECT 'Filter-Id' AS attribute_name, 'some-filter-value' AS attribute_value\nUNION\nSELECT 'Session-Timeout' AS attribute_name, '3600' AS attribute_value\nUNION\nSELECT 'Idle-Timeout' AS attribute_name, '1800' AS attribute_value