using System.Runtime.InteropServices;\nusing Extensibility;\n\nnamespace VBACustomAddIn\n{\n    [Guid("YOUR-GUID-HERE"), ProgId("VBACustomAddIn.Connect"), ComVisible(true)]\n    public class Connect : IDTExtensibility2, IVBAMacroProjectEvents\n    {\n        private CommandBar menuCommandBar = null;\n\n        public void OnConnection(object application, ext_ConnectMode connectMode, object addInInst, ref Array custom)\n        {\n            // Hook into the application here\n        }\n\n        public void OnDisconnection(ext_DisconnectMode RemoveMode, ref Array Custom)\n        {\n            // Clean up here\n        }\n\n        public void OnAddInsUpdate(ref Array custom)\n        {\n        }\n\n        public void OnStartupComplete(ref Array custom)\n        {\n            AddCommandBar();\n        }\n\n        private void AddCommandBar()\n        {\n            // Create a custom menu item in the VBE\n            var commandBars = (Microsoft.VisualStudio.CommandBars._CommandBars)ApplicationObject.VBE.CommandBars;\n            menuCommandBar = ((Microsoft.VisualStudio.CommandBars._CommandBars)commandBars).Add("My Custom Menu", Microsoft.VisualStudio.CommandBars.MsoBarPosition.msoBarLeft, missing, true);\n            \n            // Add a button to the command bar\n            var btnControl = (Microsoft.VisualStudio.CommandBars.CommandBarButton)menuCommandBar.Controls.Add(Microsoft.VisualStudio.CommandBars.MsoControlType.msoControlButton);\n            btnControl.Caption = "Custom Button";\n            btnControl.Click += new Microsoft.Office.Core._CommandBarButtonEvents_ClickEventHandler(CustomButtonClickHandler);\n        }\n\n        private void CustomButtonClickHandler(ref bool cancelDefault)\n        {\n            // Handle button click\n        }\n\n        public void OnQuit()\n        {\n        }\n\n        object ApplicationObject { get; set; }\n    }\n}