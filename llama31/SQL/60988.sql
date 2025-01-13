DECLARE\n  l_service  UTL_DBWS.service;\n  l_call     UTL_DBWS.call;\n  l_result   XMLType;\n  l_xml      XMLType;\n  l_ns       VARCHAR2(256) := 'http://example.com/mywsdl';\n  l_operation VARCHAR2(256) := 'myOperation';\n  l_input    VARCHAR2(256) := '<input>myInput</input>';\nBEGIN\n  -- Create a new service instance\n  l_service := UTL_DBWS.create_service( \n    service_name => 'myService',\n    wsdl_location => 'http://example.com/mywsdl?wsdl'\n  );\n\n  -- Create a new call instance\n  l_call := UTL_DBWS.create_call( \n    service_handle => l_service,\n    operation_name => l_operation,\n    namespace => l_ns\n  );\n\n  -- Set the input message\n  l_xml := XMLType(l_input);\n  UTL_DBWS.set_message( \n    call_handle => l_call,\n    message => l_xml,\n    message_type => 'input'\n  );\n\n  -- Invoke the web service\n  l_result := UTL_DBWS.invoke( call_handle => l_call );\n\n  -- Process the result\n  DBMS_OUTPUT.put_line(l_result.getStringVal());\nEND;