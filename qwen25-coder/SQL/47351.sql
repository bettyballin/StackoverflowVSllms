-- Publisher 1: Configure identity range management\nUSE YourDatabase;\nEXEC sp_addsubscription \n    @publication = N'YourPublicationName', \n    @subscriber = N'Subscriber2Server',\n    @destination_db = N'DestinationDatabase',\n    @subscription_type = N'Push',\n    @sync_type = N'automatic',\n    @identityrangebitmap_threshold = 10, -- Adjust as necessary\n    @publisher = N'Publisher1Server';\n\n-- Publisher 2: Configure identity range management\nUSE YourDatabase;\nEXEC sp_addsubscription \n    @publication = N'YourPublicationName', \n    @subscriber = N'Subscriber1Server',\n    @destination_db = N'DestinationDatabase',\n    @subscription_type = N'Push',\n    @sync_type = N'automatic',\n    @identityrangebitmap_threshold = 10, -- Adjust as necessary\n    @publisher = N'Publisher2Server';