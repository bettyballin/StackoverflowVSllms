using System.Windows.Forms;\n\n// ...\n\nprivate void RemoveControl(Control control)\n{\n    if (control != null)\n    {\n        control.Dispose();\n    }\n}\n\n// ...