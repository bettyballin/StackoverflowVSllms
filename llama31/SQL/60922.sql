sp_configure 'show advanced options', 1;\n   RECONFIGURE;\n   sp_configure 'max server memory', 4096;  -- Adjust this value as needed\n   RECONFIGURE;