from zeep import Client\n\ndef call_soap_service(wsdl_url, method_name, params):\n    client = Client(wsdl=wsdl_url)\n    response = client.service[method_name](**params)\n    return response\n\nwsdl_url = 'https://api.example.com/service?wsdl'\nmethod_name = 'GetData'\nparams = {'param1': 'value1', 'param2': 'value2'}\nresult = call_soap_service(wsdl_url, method_name, params)\nprint(result)