import os\nimport subprocess\n\ndef obtain_certificate(domain):\n    try:\n        # Run certbot to obtain certificate\n        subprocess.run([\n            'certbot', 'certonly', '--standalone', '-d', domain,\n            '--non-interactive', '--agree-tos', '--email', 'admin@yourdomain.com'\n        ], check=True)\n    except subprocess.CalledProcessError as e:\n        print(f"Error obtaining certificate: {e}")\n\ndef configure_ssl(server, domain):\n    cert_path = f"/etc/letsencrypt/live/{domain}/fullchain.pem"\n    key_path = f"/etc/letsencrypt/live/{domain}/privkey.pem"\n    \n    if os.path.exists(cert_path) and os.path.exists(key_path):\n        server.ssl_cert = cert_path\n        server.ssl_key = key_path\n        print(f"SSL configured for {domain}")\n    else:\n        print(f"Certificate files not found for {domain}")\n\n# Example usage\ndomain = "example.yourdomain.com"\nobtain_certificate(domain)\n# Assuming `server` is your embedded webserver instance\nconfigure_ssl(server, domain)