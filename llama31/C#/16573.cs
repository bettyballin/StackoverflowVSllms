using System;\nusing System.Drawing;\nusing System.Windows.Forms;\n\npublic class HighDpiSupport\n{\n    public static void EnableHighDpiSupport()\n    {\n        if (Environment.OSVersion.Version >= new Version(6, 3))\n        {\n            Application.SetHighDpiMode(HighDpiMode.SystemAware);\n        }\n    }\n}