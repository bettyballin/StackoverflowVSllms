CREATE FUNCTION INET_ATON (@ipAddress VARCHAR(15))\nRETURNS BIGINT\nAS\nBEGIN\n    DECLARE @result BIGINT\n    DECLARE @part1 INT, @part2 INT, @part3 INT, @part4 INT\n\n    SET @part1 = PARSENAME(@ipAddress, 4)\n    SET @part2 = PARSENAME(@ipAddress, 3)\n    SET @part3 = PARSENAME(@ipAddress, 2)\n    SET @part4 = PARSENAME(@ipAddress, 1)\n\n    SET @result = (@part1 * 256 * 256 * 256) + (@part2 * 256 * 256) + (@part3 * 256) + @part4\n\n    RETURN @result\nEND