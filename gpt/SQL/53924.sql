CREATE TABLE Closure (\n    AncestorId INT,\n    DescendantId INT,\n    Depth INT,\n    PRIMARY KEY (AncestorId, DescendantId)\n);