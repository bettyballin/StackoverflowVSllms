using System;\nusing System.Net;\nusing System.ServiceProcess;\nusing System.Threading;\n\npublic partial class MyHttpService : ServiceBase\n{\n    private HttpListener listener;\n    private Thread listenerThread;\n\n    public MyHttpService()\n    {\n        InitializeComponent();\n    }\n\n    protected override void OnStart(string[] args)\n    {\n        listener = new HttpListener();\n        listener.Prefixes.Add("http://localhost:8080/");\n        listener.Start();\n\n        listenerThread = new Thread(new ThreadStart(StartListener));\n        listenerThread.Start();\n    }\n\n    protected override void OnStop()\n    {\n        listener.Stop();\n        listenerThread.Abort();\n    }\n\n    private void StartListener()\n    {\n        while (true)\n        {\n            var result = listener.BeginGetContext(OnRequestReceive, listener);\n            result.AsyncWaitHandle.WaitOne();\n        }\n    }\n\n    private void OnRequestReceive(IAsyncResult result)\n    {\n        if (listener.IsListening)\n        {\n            HttpListenerContext context = listener.EndGetContext(result);\n            HttpListenerRequest request = context.Request;\n\n            // Process the request here\n\n            HttpListenerResponse response = context.Response;\n            string responseString = "<html><body>Request Processed</body></html>";\n            byte[] buffer = System.Text.Encoding.UTF8.GetBytes(responseString);\n            response.ContentLength64 = buffer.Length;\n            System.IO.Stream output = response.OutputStream;\n            output.Write(buffer, 0, buffer.Length);\n            output.Close();\n        }\n    }\n}