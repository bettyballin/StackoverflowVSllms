from win32com.client import Dispatch\n\nauto = Dispatch("AutoItX3.Control")\nauto.WinActivate("The window's title", "")\nauto.WinWaitActive("The window's title", "", 10)\n\nauto.Send("The input")