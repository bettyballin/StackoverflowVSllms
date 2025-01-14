FUNCTION wsproxy_send_request\nRETURN varchar2\nAS\n    l_service            SYS.UTL_DBWS.service;\n    l_call               SYS.UTL_DBWS.call;\n    l_result             ANYDATA;\n    l_wsdl_url           VARCHAR2(32767);\n    l_namespace          VARCHAR2(32767);\n    l_service_qname      SYS.UTL_DBWS.qname;\n    l_port_qname         SYS.UTL_DBWS.qname;\n    l_operation_qname    SYS.UTL_DBWS.qname;\n    l_input_params       SYS.UTL_DBWS.anydata_list := SYS.UTL_DBWS.anydata_list(); -- initialization\n    boolean_type_qname   SYS.UTL_DBWS.QNAME;\n\nBEGIN\n\n    l_wsdl_url := 'http://<<host>>/axis2/services/<<serviceName>>?wsdl';\n    l_namespace := 'http://<<namespace>>';\n    l_service_qname := SYS.UTL_DBWS.to_qname(l_namespace, '<<serviceName>>');\n    l_port_qname := SYS.UTL_DBWS.to_qname(l_namespace, '<<myendpoint>>');\n    l_operation_qname := SYS.UTL_DBWS.to_qname(l_namespace, 'send');\n\n    l_service := SYS.UTL_DBWS.create_service (wsdl_document_location => URIFACTORY.getURI(l_wsdl_url), service_name => l_service_qname);\n    l_call := SYS.UTL_DBWS.create_call ( service_handle => l_service, port_name => l_port_qname, operation_name => l_operation_qname);\n\n    SYS.UTL_DBWS.SET_PROPERTY(l_call, 'OPERATION_STYLE', 'rpc');\n\n    -- Initialize the list with actual parameters\n    EXECUTE l_input_params.extend(5);  -- Extend to accommodate the number of input parameters\n\n    l_input_params(1) := ANYDATA.ConvertNumber(1);\n    l_input_params(2) := ANYDATA.ConvertNumber(24387236726);\n    l_input_params(3) := ANYDATA.ConvertVarchar2('CTE');\n    l_input_params(4) := ANYDATA.ConvertVarchar2('STORE_RECORD_LOCATOR');\n    l_input_params(5) := ANYDATA.ConvertVarchar2('a');\n\n    boolean_type_qname := sys.utl_dbws.to_qname('http://www.w3.org/2001/XMLSchema', 'boolean');\n    sys.utl_dbws.set_return_type(l_call, boolean_type_qname);\n\n    l_result := SYS.UTL_DBWS.invoke (call_handle => l_call, input_params => l_input_params);\n\n    SYS.UTL_DBWS.release_call (call_handle => l_call);\n    SYS.UTL_DBWS.release_service(service_handle => l_service);\n\n    RETURN ANYDATA.AccessVarchar2(l_result);\nEXCEPTION\n    WHEN OTHERS THEN\n        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);\n        RAISE;\nEND;