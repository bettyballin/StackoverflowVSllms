import wx\nfrom types import MethodType\n\nclass MyWidget(wx.Window):\n    buttons = [\n        ("OK", "OnOK"),\n        ("Cancel", "OnCancel")\n    ]\n    \n    def __init__(self, parent):\n        super().__init__(parent)\n        self.setup(parent)\n\n    def setup(self, parent):\n        for text, handler_name in MyWidget.buttons:\n            handler = MethodType(getattr(self, handler_name), self)\n            b = wx.Button(parent, label=text)\n            b.Bind(wx.EVT_BUTTON, handler)\n\n    def OnOK(self, event):\n        print("OK button pressed")\n\n    def OnCancel(self, event):\n        print("Cancel button pressed")\n\n# Example usage\napp = wx.App(False)\nframe = wx.Frame(None, wx.ID_ANY, "Example")\npanel = MyWidget(frame)\nframe.Show(True)\napp.MainLoop()