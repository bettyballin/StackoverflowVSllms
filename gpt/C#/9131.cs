using System;\nusing System.Text;\nusing System.Windows.Forms;\nusing System.Net;\nusing System.Net.Sockets;\nusing System.Runtime.InteropServices;\n\nnamespace WindowsApplication1\n{\n    public partial class lanmessenger : Form\n    {\n        Socket client;\n        Socket newSock, server, hostSock, remote;\n\n        byte[] receiveBuffer = new byte[1024];\n        byte[] sendBuffer = new byte[1024];\n\n        String dataEntered;\n        StringBuilder textbox1, receivedData, sb;\n\n        IPEndPoint serverIP, clientIP;\n\n        [DllImport("user32.dll")]\n        static extern bool HideCaret(IntPtr hWnd);\n\n        Socket s = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);\n        IPAddress localaddress = IPAddress.Parse("127.0.0.1");\n\n        public lanmessenger()\n        {\n            InitializeComponent();\n        }\n\n        public void Receive()\n        {\n            if (remote.Connected)\n            {\n                remote.BeginReceive(receiveBuffer, 0, receiveBuffer.Length, SocketFlags.None, new AsyncCallback(OnReceivingData), remote);\n            }\n        }\n\n        void OnReceivingData(IAsyncResult ar)\n        {\n            try\n            {\n                remote = (Socket)ar.AsyncState;\n                int recv = remote.EndReceive(ar);\n\n                if (recv > 0)\n                {\n                    receivedData = new StringBuilder(Encoding.ASCII.GetString(receiveBuffer, 0, recv));\n                    sb = new StringBuilder(this.textBox1.Text);\n                    sb.AppendLine(receivedData.ToString());\n\n                    if (textBox1.InvokeRequired)\n                    {\n                        this.Invoke((MethodInvoker)delegate { this.textBox1.Text = sb.ToString(); });\n                    }\n                    else\n                    {\n                        this.textBox1.Text = sb.ToString();\n                    }\n\n                    // Continue receiving data\n                    remote.BeginReceive(receiveBuffer, 0, receiveBuffer.Length, SocketFlags.None, new AsyncCallback(OnReceivingData), remote);\n                }\n                else\n                {\n                    // Handle disconnection\n                    remote.Close();\n                }\n            }\n            catch (Exception ex)\n            {\n                MessageBox.Show(ex.Message, "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);\n            }\n        }\n    }\n}