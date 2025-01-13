CREATE TABLE mytable (\n  mydate DATE CHECK (DAY(mydate) = 1)\n);\n\n-- or --\n\nCREATE TRIGGER set_day_to_1\nBEFORE INSERT ON mytable\nFOR EACH ROW\nSET NEW.mydate = MAKEDATE(YEAR(NEW.mydate), 1, MONTH(NEW.mydate));