-- Original query\nSELECT * FROM orders WHERE status IS NULL OR status = 'pending';\n\n-- Optimized query for Oracle using NVL (if applicable)\nSELECT * FROM orders WHERE NVL(status, 'unknown') = 'unknown' OR status = 'pending';