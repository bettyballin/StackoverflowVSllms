import win32com.client.dynamic\n   from win32com.server.exception import Exception\n\n   class MyPythonComponent:\n       _reg_clsid_ = "{Your-GUID-Here}"\n       _reg_progid_ = "My.Python.Component"\n       _reg_desc_ = "Python Component Example"\n       _public_methods_ = ["TestMethod"]\n       \n       def TestMethod(self):\n           return "Hello from Python!"