using System;\n   using System.Runtime.InteropServices;\n   using Extensibility;\n   using Microsoft.Office.Core;\n\n   [Guid("YOUR_GUID_HERE"), ProgId("YourAddIn.ProgId")]\n   public class Connect : IDTExtensibility2\n   {\n       public void OnConnection(object application, ext_ConnectMode connectMode, object addInInst, ref Array custom)\n       {\n           // Initialize your add-in\n       }\n\n       public void OnDisconnection(ext_DisconnectMode disconnectMode, ref Array custom)\n       {\n           // Clean up your add-in\n       }\n\n       public void OnAddInsUpdate(ref Array custom) { }\n       public void OnStartupComplete(ref Array custom) { }\n       public void OnBeginShutdown(ref Array custom) { }\n   }