DECLARE\n  xml_data XMLType;\nBEGIN\n  xml_data := XMLType('<root><data>Hello World!</data></root>');\n  remote_procedure(xml_data);  -- Call the remote procedure over the DBLink\nEND;