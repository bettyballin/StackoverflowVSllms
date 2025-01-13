import requests\nfrom requests_kerberos import HTTPKerberosAuth\n\n# URL of the webpage you want to check\nurl = 'http://your-protected-webpage.com'\n\n# Kerberos authentication\nkerberos_auth = HTTPKerberosAuth()\n\nresponse = requests.get(url, auth=kerberos_auth)\n\n# Check the response\nif response.status_code == 200:\n    print("Successfully authenticated and accessed the webpage.")\n    print(response.text)\nelse:\n    print(f"Failed to access the webpage. Status code: {response.status_code}")