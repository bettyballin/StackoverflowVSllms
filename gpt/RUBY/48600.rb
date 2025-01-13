require 'oci8'\n\n# Initialize Oracle connection\nconn = OCI8.new('username', 'password', 'hostname:port/sid')\n\n# Your data to be inserted\ndata = [\n  [1, 2],\n  [3, 4],\n  [5, 6],\n  # ... more data\n]\n\n# Construct the PL/SQL block\nplsql = <<~SQL\n  DECLARE\n    TYPE t_data IS TABLE OF tablea%ROWTYPE;\n    v_data t_data := t_data();\n  BEGIN\n    v_data.EXTEND(#{data.size});\nSQL\n\ndata.each_with_index do |row, index|\n  plsql += "    v_data(#{index + 1}).id := tablea_seq.NEXTVAL;\n"\n  plsql += "    v_data(#{index + 1}).b := #{row[0]};\n"\n  plsql += "    v_data(#{index + 1}).c := #{row[1]};\n"\nend\n\nplsql += <<~SQL\n    FORALL i IN v_data.FIRST .. v_data.LAST\n      INSERT INTO tablea VALUES v_data(i);\n  END;\nSQL\n\n# Execute the PL/SQL block\nconn.exec(plsql)\n\n# Commit the transaction\nconn.commit\n\n# Close the connection\nconn.logoff