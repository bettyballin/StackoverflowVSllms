import clr\n   from System.Runtime.InteropServices import Marshal\n\n   # Replace 'ProgID.YourComponent' with the actual progID of your component\n   com_object = clr.CreateObject('ProgID.YourComponent')\n   \n   # Use the object\n   result = com_object.YourMethod()\n   print(result)