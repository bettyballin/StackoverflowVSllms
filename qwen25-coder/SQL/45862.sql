EXEC sp_addpublication_snapshot \n    @publication = N'YourPublication', \n    @frequency_type = 4,\n    @frequency_interval = 1,\n    @active_start_date = 0, \n    @active_end_date = 99991231;