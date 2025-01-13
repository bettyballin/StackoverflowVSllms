SELECT *\nFROM TableA A\nWHERE A.Column1 = 0\n   OR EXISTS(\n            SELECT B.Column1\n            FROM TableB B\n            WHERE B.Column1 = A.Column1\n            );