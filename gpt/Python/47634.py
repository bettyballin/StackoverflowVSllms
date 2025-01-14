import win32com.client\n\n# Create the COM object\nobject = win32com.client.Dispatch("VirtualBox.VirtualBox")\ndisplay = object.display\n\n# Prepare variables to hold the out parameters\naScreenId = 0  # replace with appropriate screen ID\naFramebuffer = win32com.client.VARIANT(pythoncom.VT_BYREF | pythoncom.VT_DISPATCH, None)\naXOrigin = win32com.client.VARIANT(pythoncom.VT_BYREF | pythoncom.VT_I4, 0)\naYOrigin = win32com.client.VARIANT(pythoncom.VT_BYREF | pythoncom.VT_I4, 0)\n\n# Call the method\ndisplay.getFramebuffer(aScreenId, aFramebuffer, aXOrigin, aYOrigin)\n\n# Access the out parameters\nframebuffer = aFramebuffer.value\nx_origin = aXOrigin.value\ny_origin = aYOrigin.value\n\n# Print the results\nprint(f"Framebuffer: {framebuffer}")\nprint(f"X Origin: {x_origin}")\nprint(f"Y Origin: {y_origin}")