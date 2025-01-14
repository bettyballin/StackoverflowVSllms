SET SHOWPLAN ON;\n-- Run the redundant form\nSELECT *\nFROM your_table\nWHERE \n    (A1 AND B AND C AND D)\n    OR (A2 AND B AND C AND D AND E AND F1 AND G)\n    OR (A3 AND A3a AND B AND C AND D AND E AND F1 AND G)\n    OR (A4 AND B AND C AND D AND F2);\n\n-- Run the factored form\nSELECT *\nFROM your_table\nWHERE \n    B AND C AND D AND (\n        A1\n        OR (\n            E AND F1 AND G AND (\n                A2\n                OR (A3 AND A3a)\n            )\n        )\n        OR (A4 AND F2)\n    );\nSET SHOWPLAN OFF;