CREATE TABLE MappingTable\n(\n    ColumnA INT NOT NULL,\n    ColumnB INT NOT NULL,\n    CONSTRAINT UC_ColumnA UNIQUE (ColumnA),\n    CONSTRAINT UC_ColumnB UNIQUE (ColumnB)\n);