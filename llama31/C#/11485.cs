void OnReceivingData(IAsyncResult ar)\n{\n    remote = (Socket)ar.AsyncState;\n    int recv = remote.EndReceive(ar);\n    \n    receivedData = new StringBuilder(Encoding.ASCII.GetString(receiveBuffer, 0, recv));\n    sb = new StringBuilder(this.textBox1.Text);\n    sb.AppendLine(receivedData.ToString());\n    \n    if (textBox1.InvokeRequired)\n    {\n        this.Invoke((MethodInvoker)delegate { this.textBox1.Text = sb.ToString(); });\n    }\n    \n    Receive(); // Call Receive again to continue receiving data\n    \n    return;\n}