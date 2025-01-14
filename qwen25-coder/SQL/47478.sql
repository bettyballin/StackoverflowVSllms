CREATE PROCEDURE GetFilteredData\n       @param1 datatype,\n       @param2 datatype,\n       -- Add other parameters as necessary\n   AS\n   BEGIN\n       SELECT *\n       FROM YourTable t\n       WHERE (@param1 IS NULL OR t.column1 = @param1)\n         AND (@param2 IS NULL OR t.column2 = @param2)\n         -- Add conditions for other parameters\n   END