BEGIN\n    DBMS_AQADM.CREATE_QUEUE_TABLE(\n        queue_table => 'STAGING_QUEUE_TAB',\n        queue_payload_type => 'SYS.AQ$_JMS_TEXT_MESSAGE');\nEND;