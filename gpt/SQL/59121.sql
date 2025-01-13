CREATE TABLE matches(\n        offsetRow1 INT, \n        offsetCol1 INT, \n        offsetRow2 INT, \n        ofsetCol2 INT, \n        directions VARCHAR(20)\n    );\n\n    -- Insert horizontal match patterns\n    INSERT INTO matches VALUES(-1, -1, -1, -2, 'up');\n    INSERT INTO matches VALUES(-1, -1, -1, 1, 'up');\n    INSERT INTO matches VALUES(-1, 1, -1, 2, 'up');       \n    INSERT INTO matches VALUES(1, -1, 1, -2, 'down');          \n    INSERT INTO matches VALUES(1, -1, 1, 1, 'down');   \n    INSERT INTO matches VALUES(1, 1, 1, 2, 'down');      \n    INSERT INTO matches VALUES(0, -2, 0, -3, 'left');    \n    INSERT INTO matches VALUES(0, 2, 0, 3, 'right'); \n\n    -- Insert vertical match patterns\n    INSERT INTO matches VALUES(-2, -1, -1, -1, 'left'); \n    INSERT INTO matches VALUES(-1, -1, 1, -1, 'left'); \n    INSERT INTO matches VALUES(1, -1, 2, -1, 'left'); \n    INSERT INTO matches VALUES(-2, 1, -1, 1, 'right'); \n    INSERT INTO matches VALUES(-1, 1, 1, 1, 'right'); \n    INSERT INTO matches VALUES(1, 1, 2, 1, 'right'); \n    INSERT INTO matches VALUES(-2, 0, -3, 0, 'up'); \n    INSERT INTO matches VALUES(2, 0, 3, 0, 'down');