ALTER TABLE Employee\nADD CONSTRAINT FK_Employee_Code1\nFOREIGN KEY (Code1)\nREFERENCES Code(Id)\nON DELETE SET NULL;\n\nALTER TABLE Employee\nADD CONSTRAINT FK_Employee_Code2\nFOREIGN KEY (Code2)\nREFERENCES Code(Id)\nON DELETE SET NULL;\n\n-- Repeat for other foreign key constraints as needed