CREATE TABLE MyTable (\n    MyColumn INT,\n    CONSTRAINT CHK_MyColumn CHECK (MyColumn BETWEEN 1 AND 5)\n)