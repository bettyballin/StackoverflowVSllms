<?php\nclass Search {\n    public $Request;\n}\n\nclass SearchRequest {\n    public $AppID;\n    public $Query;\n    public $CultureInfo;\n    public $SafeSearch;\n    public $Flags;\n    public $Requests;\n}\n\nclass SourceRequest {\n    public $Source;\n    public $Offset;\n    public $Count;\n    public $FileType;\n    public $SortBy;\n    public $ResultFields;\n    public $SearchTagFilters;\n}\n\ntry {\n    $server = new SoapClient('http://soap.search.msn.com/webservices.asmx?wsdl');\n\n    $searchRequest = new SourceRequest();\n    $searchRequest->Source = 'Web';\n    $searchRequest->Offset = 0;\n    $searchRequest->Count = 5;\n    $searchRequest->ResultFields = 'All SearchTagsArray';\n\n    $request = new SearchRequest();\n    $request->AppID = 'YOUR_APP_ID_HERE'; // Replace with your actual AppID\n    $request->Query = 'Bill Gates';\n    $request->CultureInfo = 'en-US';\n    $request->SafeSearch = 'Off';\n    $request->Flags = '';\n    $request->Requests = array($searchRequest);\n\n    $search = new Search();\n    $search->Request = $request;\n\n    $response = $server->Search(array('Request' => $search->Request));\n    print_r($response);\n} catch (SoapFault $e) {\n    echo "SOAP Fault: (faultcode: {$e->faultcode}, faultstring: {$e->faultstring})";\n}\n?>