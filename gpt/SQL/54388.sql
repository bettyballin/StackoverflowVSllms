-- Step 1: Configure Publisher\nEXEC sp_replicationdboption \n    @dbname = 'YourDatabase', \n    @optname = 'publish', \n    @value = 'true';\n\n-- Step 2: Create a Publication\nEXEC sp_addpublication \n    @publication = 'YourPublication',\n    @status = N'active',\n    @allow_push = N'true',\n    @allow_pull = N'true';\n    \n-- Step 3: Add Articles (Tables) to the Publication\nEXEC sp_addarticle \n    @publication = 'YourPublication', \n    @article = 'ASPStateTempSessions',\n    @source_object = 'ASPStateTempSessions';\n    \nEXEC sp_addarticle \n    @publication = 'YourPublication', \n    @article = 'ASPStateTempApplications',\n    @source_object = 'ASPStateTempApplications';\n\n-- Step 4: Configure Subscriber\nEXEC sp_addsubscription \n    @publication = 'YourPublication', \n    @subscriber = 'YourSubscriberServer', \n    @destination_db = 'YourDestinationDatabase';\n    \n-- Step 5: Initialize the Subscription\nEXEC sp_startpublication_snapshot \n    @publication = 'YourPublication';