BEGIN\n      DBMS_AQADM.MANUAL_PROPAGATE(\n        queue_name => 'Test_Q',\n        destination => 'Dest_Q'\n      );\n    END;