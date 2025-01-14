import subprocess\nimport win32com.client\nimport time\nimport psutil\n\ndef start_excel_instance():\n    # Start a new Excel process\n    subprocess.Popen(['excel.exe'])\n    time.sleep(2)  # Wait for the Excel process to start\n\n    # Find the process ID of the new Excel instance\n    for proc in psutil.process_iter(['pid', 'name']):\n        if proc.info['name'] == 'EXCEL.EXE':\n            return proc.info['pid']\n    return None\n\ndef attach_to_excel_instance(pid):\n    # Attach to the specific Excel instance by its process ID\n    excel_app = win32com.client.Dispatch("Excel.Application", clsctx=win32com.client.constants.CLSCTX_LOCAL_SERVER, userName=None, machineName=None, clsid=None, lcid=None, queryInterface=None, bForUser=True, bForMachine=False, pid=pid)\n    return excel_app\n\n# Start two separate Excel instances\npid1 = start_excel_instance()\npid2 = start_excel_instance()\n\nif pid1 and pid2:\n    # Attach to each Excel instance\n    excel1 = attach_to_excel_instance(pid1)\n    excel2 = attach_to_excel_instance(pid2)\n    \n    # Make Excel instances visible\n    excel1.Visible = True\n    excel2.Visible = True\n    \n    # Now you can control each instance independently\n    workbook1 = excel1.Workbooks.Add()\n    workbook2 = excel2.Workbooks.Add()\n    \n    # Example of writing to the first cell in each workbook\n    workbook1.Sheets(1).Cells(1, 1).Value = "Instance 1"\n    workbook2.Sheets(1).Cells(1, 1).Value = "Instance 2"\n\nelse:\n    print("Failed to start Excel instances.")