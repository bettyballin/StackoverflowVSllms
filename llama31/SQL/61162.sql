ALTER function [dbo].[udf_create_acs] (@MasterCustomerId varchar(26))\nreturns varchar(30)\nas\nbegin\n    --this implements the "mod 10" check digit calculation\n    --for the US Postal Service ACS function, from "Publication 8A"\n    --found at "http://www.usps.com/cpim/ftp/pubs/pub8a.pdf"\n    declare @result varchar(30)\n    declare @current_char int\n    declare @total_value int\n    declare @check_digit varchar(1)\n    declare @digit int\n\n    set @total_value = 0\n    set @current_char = 1\n\n    --stepping through the string one character at a time\n    while (@current_char <= len(@MasterCustomerId)) begin\n        --this is the calculation for the character's weighted value\n        set @digit = convert(int, substring(@MasterCustomerId, @current_char, 1))\n\n        if (@current_char % 2 = 0) begin\n            --it is an even position, so just add the digit's value\n            set @total_value = @total_value + @digit\n        end else begin\n            --it is an odd position, so multiply the digit by 2 and sum the resulting digits\n            set @total_value = @total_value + ((@digit * 2) / 10) + ((@digit * 2) % 10)\n        end\n\n        set @current_char = @current_char + 1\n    end\n\n    --find the check digit (character) using the formula in the USPS document\n    set @check_digit = convert(varchar,(10 - (@total_value % 10)) % 10)\n\n    set @result = '#' + @MasterCustomerId + '   ' + @check_digit + '#'\n\n    return @result\nend