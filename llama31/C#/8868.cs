using Microsoft.Web.Administration;\n\npublic class InstallerClass\n{\n    public void CheckIISVersion()\n    {\n        using (ServerManager serverManager = new ServerManager())\n        {\n            if (serverManager.ApplicationPoolsSupported)\n            {\n                // IIS supports application pools, proceed with creation\n            }\n            else\n            {\n                // IIS does not support application pools, handle accordingly\n            }\n        }\n    }\n}