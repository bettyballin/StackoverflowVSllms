import pythoncom\n\nclass HelloWorld:\n    _reg_clsctx_ = pythoncom.CLSCTX_LOCAL_SERVER\n    _reg_clsid_ = "{B83DD222-7750-413D-A9AD-01B37021B24B}"\n    _reg_desc_ = "Python Test COM Server"\n    _reg_progid_ = "Python.TestServer"\n    _public_methods_ = ['Hello']\n    _public_attrs_ = ['softspace', 'noCalls']\n    _readonly_attrs_ = ['noCalls']\n    # for Python 3.7+\n    _reg_verprogid_ = "Python.TestServer.1"\n    _reg_class_spec_ = "HelloWorldCOM.HelloWorld"\n\n    def __init__(self):\n        self.softspace = 1\n        self.noCalls = 0\n\n    def Hello(self, who):\n        self.noCalls = self.noCalls + 1\n        # insert "softspace" number of spaces\n        return "Hello" + " " * self.softspace + str(who)\n\nif __name__ == '__main__':\n    if '--register' in sys.argv[1:] or '--unregister' in sys.argv[1:]:\n        import win32com.server.register\n        win32com.server.register.UseCommandLine(HelloWorld)\n    else:\n        # start the server.\n        from win32com.server import localserver\n        localserver.serve(['{B83DD222-7750-413D-A9AD-01B37021B24B}'])