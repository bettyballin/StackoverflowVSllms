ALTER TABLE ChildTable\nADD FOREIGN KEY (ParentID)\nREFERENCES ParentTable(ID)\nON DELETE CASCADE;