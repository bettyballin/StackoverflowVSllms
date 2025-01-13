# Navigate to the WebSphere profile's config directory\ncd /opt/IBM/WebSphere/AppServer/profiles/<Your_Profile>/config/cells/<Your_Cell>/nodes/<Your_Node>/servers/<Your_Server>\n\n# Edit the ssl.client.props file\nvi ssl.client.props\n\n# Ensure the following properties are set to true for enabling TLS protocols\ncom.ibm.ssl.protocol=TLSv1.2\ncom.ibm.ssl.enabledCipherSuites=SSL_RSA_WITH_AES_128_CBC_SHA,SSL_RSA_WITH_AES_256_CBC_SHA\n\n# Save and close the file