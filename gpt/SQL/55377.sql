EXEC sp_addpublication @publication = 'YourPublication', @description = 'Transactional publication of YourDatabase', @sync_method = 'concurrent', @retention = 0, @allow_push = true, @allow_pull = true, @allow_anonymous = true, @enabled_for_internet = false, @snapshot_in_defaultfolder = true, @compress_snapshot = false, @ftp_port = 21, @ftp_login = 'anonymous', @allow_subscription_copy = false, @add_to_active_directory = false, @repl_freq = 'continuous', @status = 'active';