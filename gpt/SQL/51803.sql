WITH NumberedURLs AS (\n    SELECT\n        url,\n        site,\n        ROW_NUMBER() OVER (PARTITION BY site ORDER BY url) AS rn\n    FROM\n        urls\n)\nSELECT\n    url\nFROM\n    NumberedURLs\nORDER BY\n    rn, site;