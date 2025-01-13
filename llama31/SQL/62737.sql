ALTER TABLE masterTable\nADD TrimmedTextField AS (LTRIM(RTRIM(COALESCE(TextField,'')))) PERSISTED\n\nCREATE INDEX IX_TrimmedTextField ON masterTable (TrimmedTextField)\n\nALTER TABLE incomingDataTable\nADD TrimmedTextField AS (LTRIM(RTRIM(COALESCE(TextField,'')))) PERSISTED\n\nCREATE INDEX IX_TrimmedTextField ON incomingDataTable (TrimmedTextField)