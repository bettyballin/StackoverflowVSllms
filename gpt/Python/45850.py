import win32com.client\nimport time\n\n# Create an Internet Explorer instance\nie = win32com.client.Dispatch("InternetExplorer.Application")\nie.Visible = False\n\n# Navigate to the desired webpage\nie.Navigate("http://www.bmreports.com/servlet/com.logica.neta.bwp_PanBMDataServlet?param1=&param2=&param3=&param4=&param5=2009-04-22&param6=37#")\ntime.sleep(20)  # Allow time for the page to load\n\n# Access the document's head\ndocument_head = ie.document.head.innerHTML\n\n# Extract the gs_csv variable from the head\nstart_index = document_head.find("var gs_csv = '") + len("var gs_csv = '")\nend_index = document_head.find("';", start_index)\ngs_csv_data = document_head[start_index:end_index]\n\n# Save the gs_csv data to a file\nscript_filepath = "c:\\FO Share\\bmreports\\script.txt"\nwith open(script_filepath, 'w', encoding='utf-8') as script_file:\n    script_file.write(gs_csv_data.replace('\\n', '\n'))\n\n# Quit Internet Explorer\nie.Quit()\n\n# Print the gs_csv data (optional)\nprint(gs_csv_data)