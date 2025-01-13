// Shared constants\npublic const int HeaderLength = 8; // adjust to your header length\n\n// Request-response mapping data structure\npublic class RequestResponseMap {\n    private Dictionary<Guid, Response> _map = new Dictionary<Guid, Response>();\n\n    public void AddRequest(Guid requestId) {\n        _map.Add(requestId, null);\n    }\n\n    public void SetResponse(Guid requestId, Response response) {\n        _map[requestId] = response;\n    }\n\n    public Response GetResponse(Guid requestId) {\n        return _map[requestId];\n    }\n}\n\n// Client-side implementation\npublic class Client {\n    private Socket _socket;\n    private RequestResponseMap _requestResponseMap = new RequestResponseMap();\n\n    public void SendRequest(Request request) {\n        Guid requestId = Guid.NewGuid();\n        request.RequestId = requestId;\n        _requestResponseMap.AddRequest(requestId);\n        // Send the request over the socket\n        _socket.Send(request.GetBytes());\n    }\n\n    public Response ReceiveResponse() {\n        // Receive a response from the server\n        byte[] responseBytes = _socket.Receive();\n        Response response = Response.FromBytes(responseBytes);\n        _requestResponseMap.SetResponse(response.RequestId, response);\n        return response;\n    }\n}\n\n// Server-side implementation\npublic class Server {\n    private Socket _socket;\n    private RequestResponseMap _requestResponseMap = new RequestResponseMap();\n\n    public void HandleClientRequest(Request request) {\n        Guid requestId = request.RequestId;\n        // Process the request and generate a response\n        Response response = ProcessRequest(request);\n        response.RequestId = requestId;\n        _requestResponseMap.SetResponse(requestId, response);\n        // Send the response back to the client\n        _socket.Send(response.GetBytes());\n    }\n}