import hmac\nimport hashlib\nimport base64\n\ndef generate_mac(data, key):\n    # Create the HMAC object\n    hmac_obj = hmac.new(key.encode(), data.encode(), hashlib.sha256)\n    \n    # Generate the HMAC digest\n    mac = hmac_obj.digest()\n    \n    # Encode the MAC in a URL-safe base64 format and truncate to 4 characters\n    mac_truncated = base64.urlsafe_b64encode(mac).decode()[:4]\n    \n    return mac_truncated\n\n# Example usage\nbusiness_data_id = "12345"\nlogged_on_user_id = "user123"\nsecret_key = "your_secret_key"\n\ndata = f"{business_data_id}{logged_on_user_id}"\nmac = generate_mac(data, secret_key)\nprint(f"URL Parameter with MAC: ?id={business_data_id}&mac={mac}")