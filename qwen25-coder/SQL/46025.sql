ALTER FUNCTION [dbo].[udf_create_acs] (@MasterCustomerId VARCHAR(26))\nRETURNS VARCHAR(30)\nAS\nBEGIN\n    -- This implements the "mod 10" check digit calculation\n    -- for the US Postal Service ACS function, from "Publication 8A"\n    DECLARE @result VARCHAR(30)\n    DECLARE @current_char INT\n    DECLARE @char_positions_odd VARCHAR(10)\n    DECLARE @total_value INT\n    DECLARE @check_digit INT\n\n    -- These strings represent the pre-calculated values of each character\n    -- for odd positions: '7' in an odd position in the input becomes 14, which is 1+4=5\n    SET @char_positions_odd = '0246813579'\n    SET @total_value = 0\n    SET @current_char = 1\n\n    -- Stepping through the string one character at a time\n    WHILE (@current_char <= LEN(@MasterCustomerId)) BEGIN\n        -- This is the calculation for the character's weighted value\n        IF ((@current_char % 2) = 1) BEGIN\n            -- It is an odd position, so look up the pre-calculated value for the digit\n            SET @total_value = @total_value + \n                (CHARINDEX(SUBSTRING(@MasterCustomerId, @current_char, 1), @char_positions_odd) - 1)\n        END ELSE BEGIN\n            -- It is an even position, so just add the digit's value\n            SET @total_value = @total_value + CONVERT(INT, SUBSTRING(@MasterCustomerId, @current_char, 1))\n        END\n\n        SET @current_char = @current_char + 1\n    END\n\n    -- Find the check digit using the formula in the USPS document\n    SET @check_digit = (10 - (@total_value % 10)) % 10\n\n    SET @result = '#' + @MasterCustomerId + '   ' + CONVERT(VARCHAR, @check_digit) + '#'\n\n    RETURN @result\nEND