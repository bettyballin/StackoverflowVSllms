-- At the Publisher\nEXEC sp_replicationdboption \n    @dbname = N'YourPublisherDB', \n    @optname = N'publish', \n    @value = N'true';\n\nEXEC sp_addpublication \n    @publication = N'YourPublication', \n    @status = N'active';\n\nEXEC sp_addpublication_snapshot \n    @publication = N'YourPublication';\n\nEXEC sp_addarticle \n    @publication = N'YourPublication', \n    @article = N'YourTable', \n    @source_owner = N'dbo', \n    @source_object = N'YourTable', \n    @type = N'logbased';\n\n-- At the Subscriber\nEXEC sp_addsubscription \n    @publication = N'YourPublication', \n    @subscriber = N'yourSubscriberServer', \n    @destination_db = N'YourSubscriberDB', \n    @subscription_type = N'push', \n    @sync_type = N'automatic', \n    @article = N'all';