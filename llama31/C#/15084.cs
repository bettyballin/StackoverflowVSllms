using Microsoft.AspNet.SignalR;\n\npublic class MyHub : Hub\n{\n    public void UpdateData(Data data)\n    {\n        Clients.All.updateData(data);\n    }\n}