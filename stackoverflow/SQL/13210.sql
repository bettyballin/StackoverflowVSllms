/* TEST TABLE */\nDECLARE @T AS TABLE(code Varchar(20))\nINSERT INTO @T SELECT 'ab1234x1'   UNION SELECT ' ab1234x2' \n         UNION SELECT '  ab1234x3' UNION SELECT 'a b1234x4' \n         UNION SELECT 'a  b1234x5' UNION SELECT 'a   b1234x6' \n         UNION SELECT 'ab 1234x7'  UNION SELECT 'ab  1234x8' \n\nSELECT * FROM @T\n/* INPUT\n    code\n    --------------------\n      ab1234x3\n     ab1234x2\n    a   b1234x6\n    a  b1234x5\n    a b1234x4\n    ab  1234x8\n    ab 1234x7\n    ab1234x1\n*/\n\n/* START PROCESSING SECTION */\nDECLARE @s Varchar(20)\nDECLARE @firstChar INT\nDECLARE @secondChar INT\n\nUPDATE @T SET\n     @firstChar = PATINDEX('%[^ ]%',code)\n    ,@secondChar = @firstChar + PATINDEX('%[^ ]%',  STUFF(code,1, @firstChar,'' ) )\n    ,@s = STUFF(\n            code,\n            1,\n            @secondChar,\n            REPLACE(LEFT(code,\n                    @secondChar\n                ),' ','')\n        ) \n     ,@s = STUFF(\n            @s, \n            1,\n            2,\n            UPPER(LEFT(@s,2))\n        )\n    ,code = @s\n/* END PROCESSING SECTION */\n\nSELECT * FROM @T\n/* OUTPUT\n    code\n    --------------------\n    AB1234x3\n    AB1234x2\n    AB1234x6\n    AB1234x5\n    AB1234x4\n    AB  1234x8\n    AB 1234x7\n    AB1234x1\n*/