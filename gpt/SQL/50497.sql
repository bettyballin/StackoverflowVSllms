CREATE NONCLUSTERED INDEX idx_c2\nON table1 (c2)\nINCLUDE (c1, c3, c4, c5);\n\nCREATE NONCLUSTERED INDEX idx_c3\nON table1 (c3)\nINCLUDE (c1, c2, c4, c5);\n\nCREATE NONCLUSTERED INDEX idx_c4\nON table1 (c4)\nINCLUDE (c1, c2, c3, c5);\n\nCREATE NONCLUSTERED INDEX idx_c5\nON table1 (c5)\nINCLUDE (c1, c2, c3, c4);