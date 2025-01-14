DECLARE\n  req  UTL_HTTP.req;\n  resp UTL_HTTP.resp;\n  value VARCHAR2(1024);\nBEGIN\n  -- Set up the request\n  req := UTL_HTTP.begin_request('http://example.com/service', 'POST');\n  UTL_HTTP.set_header(req, 'User-Agent', 'Mozilla/4.0');\n  UTL_HTTP.set_header(req, 'Content-Type', 'text/xml');\n\n  -- Write the SOAP request body\n  UTL_HTTP.write_text(req, '<?xml version="1.0" encoding="utf-8"?>\n                            <soap:Envelope xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"\n                                           xmlns:xsd="http://www.w3.org/2001/XMLSchema"\n                                           xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/">\n                              <soap:Body>\n                                <GetDataRequest xmlns="http://example.com/service"/>\n                              </soap:Body>\n                            </soap:Envelope>');\n\n  -- Get the response\n  resp := UTL_HTTP.get_response(req);\n  BEGIN\n    LOOP\n      UTL_HTTP.read_text(resp, value, 1024);\n      DBMS_OUTPUT.PUT_LINE(value);\n    END LOOP;\n  EXCEPTION\n    WHEN UTL_HTTP.end_of_body THEN\n      UTL_HTTP.end_response(resp);\n  END;\n\nEXCEPTION\n  WHEN OTHERS THEN\n    UTL_HTTP.end_response(resp);\n    RAISE;\nEND;