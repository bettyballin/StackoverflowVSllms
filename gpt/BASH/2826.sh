# Example of setting HSTS in IIS:\nAdd-WebConfiguration -Filter "system.webServer/httpProtocol/customHeaders" -Value @{name='Strict-Transport-Security';value='max-age=31536000; includeSubDomains'} -PSPath "IIS:\Sites\Default Web Site"