CREATE FUNCTION int_to_varchar_bit_data (val INTEGER)\n    RETURNS VARCHAR(2) FOR BIT DATA\n    BEGIN\n        RETURN chr(bitand(val, 0xFF00) / 256) || chr(bitand(val, 0x00FF));\n    END