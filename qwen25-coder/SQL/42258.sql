SET ANSI_NULLS ON;\nDECLARE @1 INT;\nDECLARE @2 INT;\nDECLARE @3 INT;\nDECLARE @4 INT;\n\nSET @1 = 1;\nSET @2 = NULL;\nSET @3 = 3;\nSET @4 = 3;\n\nIF ((@1 <> @2 OR (@1 IS NOT NULL AND @2 IS NULL)) OR (@3 <> @4))\n   BEGIN\n     SELECT 1;\n   END\nELSE\n   BEGIN\n     SELECT 2;\n   END\n\nSELECT @1, @2, @3, @4