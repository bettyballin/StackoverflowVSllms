import requests\n\n# Example: Set permissions on a file or directory\ndef set_permissions(url, token, path, share_type, share_with):\n    headers = {\n        'Authorization': f'Bearer {token}',\n        'Content-Type': 'application/json'\n    }\n    data = {\n        "path": path,\n        "shareType": share_type,  # 0: user; 1: group\n        "shareWith": share_with   # username or group name\n    }\n    \n    response = requests.post(f'{url}/ocs/v2.php/apps/files_sharing/api/v1/shares', headers=headers, data=data)\n    return response.json()\n\n# Usage of the function\nnextcloud_url = 'https://your-nextcloud-instance.com'\napi_token = 'YOUR_API_TOKEN'\nfile_path = '/path/to/file'\ngroup_name = 'YourGroupName'\n\nresult = set_permissions(nextcloud_url, api_token, file_path, 1, group_name)\nprint(result)