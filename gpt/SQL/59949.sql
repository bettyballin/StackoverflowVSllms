EXEC sp_addmergepullsubscription_agent \n       @publication = 'YourPublicationName', \n       @subscriber = 'YourSubscriberName', \n       @subscriber_db = 'YourSubscriberDB', \n       @publisher_security_mode = 1, \n       @distributor_security_mode = 1, \n       @publisher = 'YourPublisherName',\n       @alt_snapshot_folder = N'\\Path\To\Snapshot\Directory';