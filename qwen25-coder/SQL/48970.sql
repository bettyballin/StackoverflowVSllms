create or replace package LE2_P1 is\n    procedure GENERATE_MULTIPLICATION_TABLE(p_axis_both in number);\n    procedure GENERATE_MULTIPLICATION_TABLE(p_axis_x in number, p_axis_y in number);\nend LE2_P1;\n/\n\ncreate or replace package body LE2_P1 as\n    procedure GENERATE_MULTIPLICATION_TABLE(p_axis_both in number) is\n        bb number := 1;\n        eb number := p_axis_both;\n    begin\n        for xyz in 1 .. eb loop\n            for xyx in 1 .. eb loop\n                dbms_output.put(CHR(9) || to_char(xyz * (bb + xyx - 1)));\n            end loop;\n            dbms_output.put_line(CHR(13) || CHR(10));\n        end loop;\n    end GENERATE_MULTIPLICATION_TABLE;\n\n    procedure GENERATE_MULTIPLICATION_TABLE(p_axis_x in number, p_axis_y in number) is\n        bb number := p_axis_x;\n        eb number:= p_axis_y;\n    begin\n        for xyz in 1 .. eb loop\n            for xyx in 1 .. bb loop\n                dbms_output.put(CHR(9) || to_char(xyz * xyx));\n            end loop;\n            dbms_output.put_line(CHR(13) || CHR(10));\n        end loop;\n    end GENERATE_MULTIPLICATION_TABLE;\n\nend LE2_P1;\n/\n\ndeclare\n    x number := 5;\n    y number := 3;\nbegin\n    LE2_P1.GENERATE_MULTIPLICATION_TABLE(x, y);\nend;\n/