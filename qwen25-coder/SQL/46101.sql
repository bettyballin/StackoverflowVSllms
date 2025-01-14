-- Optional: Create an Extended Events session for tracking T-SQL batches\nCREATE EVENT SESSION [CaptureQueryDetails]\nON SERVER \nADD EVENT sqlserver.sql_batch_completed(\n    ACTION(sqlserver.database_id, sqlserver.sql_text)\n),\nADD EVENT sqlserver.rpc_completed(\n    ACTION(sqlserver.database_id, sqlserver.sql_text)\n)\nADD TARGET package0.event_file(SET filename=N'C:\temp\QueryDetails.xel', max_file_size=(5), max_rollover_files=(2))\nWITH (MAX_MEMORY=4096 KB, EVENT_RETENTION_MODE=ALLOW_SINGLE_EVENT_LOSS, MAX_DISPATCH_LATENCY=30 SECONDS, MAX_EVENT_SIZE=0 KB, MEMORY_PARTITION_MODE=NONE, TRACK_CAUSALITY=OFF, STARTUP_STATE=OFF);\nGO\n\n-- Start the event session\nALTER EVENT SESSION [CaptureQueryDetails] ON SERVER STATE = START;