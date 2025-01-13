using System;\nusing System.Collections;\nusing System.ComponentModel;\nusing System.Configuration.Install;\nusing System.DirectoryServices;\n\nnamespace CustomActions\n{\n    [RunInstaller(true)]\n    public partial class CustomInstaller : Installer\n    {\n        public override void Install(IDictionary stateSaver)\n        {\n            base.Install(stateSaver);\n            DisableAnonymousAccess();\n        }\n\n        private void DisableAnonymousAccess()\n        {\n            string siteName = Context.Parameters["siteName"];\n            string virtualDirName = Context.Parameters["virtualDirName"];\n            string path = $"IIS://localhost/W3SVC/{siteName}/Root/{virtualDirName}";\n\n            using (DirectoryEntry virtualDirEntry = new DirectoryEntry(path))\n            {\n                virtualDirEntry.Properties["AuthFlags"][0] = 2; // 2 means disable anonymous access\n                virtualDirEntry.CommitChanges();\n            }\n        }\n    }\n}