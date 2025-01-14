-- Enable Actual Execution Plan\n   SET STATISTICS PROFILE ON;\n   \n   -- Your query\n   SELECT\n       T.Id AS Shared_Id,\n       V.Superior_Id,\n       V.Superior_topicTitle,\n       V.Subordinate_Id,\n       V.Subordinate_Folder_Id,\n       V.Subordinate_topicXhtml\n   FROM Topic AS T, View_Topic_Ancestor AS V\n   WHERE Folder_Id='e2eb2b68-738d-49ad-9787-a1e655b7973f'\n   AND T.crossLinked = V.Subordinate_Id;\n   \n   -- Disable Actual Execution Plan\n   SET STATISTICS PROFILE OFF;