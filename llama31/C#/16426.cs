using System;\nusing System.Net;\nusing System.Net.Sockets;\nusing System.Text;\n\npublic class PeerToPeer\n{\n    private UdpClient _udpClient;\n\n    public PeerToPeer(int port)\n    {\n        _udpClient = new UdpClient(port);\n        _udpClient.EnableBroadcast = true;\n    }\n\n    public void Send(string message)\n    {\n        byte[] data = Encoding.ASCII.GetBytes(message);\n        _udpClient.Send(data, data.Length, new IPEndPoint(IPAddress.Broadcast, _udpClient.Client.LocalEndPoint.Port));\n    }\n\n    public string Receive()\n    {\n        IPEndPoint remoteEndPoint = null;\n        byte[] data = _udpClient.Receive(ref remoteEndPoint);\n        return Encoding.ASCII.GetString(data);\n    }\n}