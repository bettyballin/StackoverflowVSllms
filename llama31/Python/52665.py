import win32com.client\n\napp = win32com.client.Dispatch('Excel.Application')\napp.Visible = True\napp.Workbooks.Add()\napp.Quit()