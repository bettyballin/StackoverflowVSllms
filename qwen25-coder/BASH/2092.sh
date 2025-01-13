#!/bin/sh\n\n# Define the database connection details\ndb_name="your_db_name"\nuser="your_user"\npassword="your_password"\n\n# Connect to the DB2 database and execute commands\necho "\nCONNECT TO $db_name USER $user USING $password;\nALTER TABLE work_item DROP COLUMN TRANSACTION_TYPE;\nALTER TABLE work_item DROP COLUMN REQUEST_TYPE;\nALTER TABLE work_item DROP COLUMN LOCATION_CODE;\nALTER TABLE work_item DROP COLUMN ROLE_ID;\nALTER TABLE work_item DROP COLUMN SUBMITTED_BY;\nRUNSTATS ON TABLE your_schema.work_item WITH DISTRIBUTION AND DETAILED INDEXES ALL;\nREORG TABLE your_schema.work_item;\nCONNECT RESET;\n" | db2 -tf -\n\necho "Columns dropped and table reorganized."