-- Numeric Types\nINTEGER          -- 2-byte integer\nLONG             -- 4-byte integer\nBYTE             -- 1-byte integer\nCURRENCY         -- 8-byte currency value\nSINGLE           -- Single-precision floating point number (4 bytes)\nDOUBLE           -- Double-precision floating point number (8 bytes)\n\n-- Date and Time Types\nDATE.TIME        -- Date and time (stored as a double)\nTIME.STAMP       -- Timestamp of record creation or last modification\n\n-- Text Types\nTEXT             -- Variable-length text, up to 255 characters (for shorter text)\nMEMO             -- Longer text, up to approximately 64kb\n\n-- Boolean Type\nYES.NO           -- Logical data type; True/False values stored as -1/0\nBOOLEAN          -- Equivalent to YES.NO in Access SQL syntax\n\n-- Binary Types\nBINARY           -- Variable-length binary, up to 255 bytes\nBYTES            -- Longer binary data (OLE objects) (up to approximately 64kb)\nLONG.BINARY      -- Up to approximately 2gb of binary data\n\n-- Special Types\nAUTONUMBER       -- Auto-incrementing integer, often used for primary keys\nGUID             -- Globally unique identifier