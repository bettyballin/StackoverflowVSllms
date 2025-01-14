<?php\n$c = oci_pconnect('username', 'password', '//localhost/XE');\n\n// Assuming we are in ON COMMIT PRESERVE ROWS mode\n$stmtInsert = oci_parse($c, "INSERT INTO your_global_temp_table (column1) VALUES ('value1')");\noci_execute($stmtInsert);\n\n// Commit can be used to clear data in ON COMMIT DELETE ROWS mode\noci_commit($c);\n\n// To explicitly end the session and clear ON COMMIT PRESERVE ROWS data:\noci_close($c);\n?>