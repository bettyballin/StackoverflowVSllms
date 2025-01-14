import requests\nfrom xml.etree import ElementTree\n\n# URL of the CruiseControl.NET XML report\nreport_url = 'http://.../XmlBuildReport.aspx'\n\n# Fetch the XML report\nresponse = requests.get(report_url)\nresponse.raise_for_status()  # Raise an error for bad responses\n\n# Parse the XML content\nroot = ElementTree.fromstring(response.content)\n\n# Find the project node (assuming you know the project name)\nproject_name = 'MyProject'\nproject_node = root.find(f".//Build[@name='{project_name}']")\n\nif project_node is not None:\n    # Get the status of the last build\n    build_status = project_node.attrib.get('status', '').lower()\n    \n    if build_status == 'success':\n        print("Build was successful")\n    else:\n        print("Build failed or has a different status:", build_status)\nelse:\n    print(f"Project {project_name} not found in the report.")