UPDATE databasename..VersionedFields\nSET Value = REPLACE(REPLACE(Value, '<iframe', '<a><iframe'), '</iframe>', '</iframe></a>')\nWHERE Value LIKE '%<iframe%';