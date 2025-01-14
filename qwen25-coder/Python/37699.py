# Example Flask app for verifying fingerprint and IP address\nfrom flask import Flask, request, jsonify\n\napp = Flask(__name__)\n\n# Store allowed fingerprints and IPs in a secure manner\nallowed_fingerprints = {'your_expected_hash_here'}\nallowed_ips = {'192.168.1.0/24'}  # Example subnet\n\n@app.route('/verify-fingerprint', methods=['POST'])\ndef verify_fingerprint():\n    data = request.get_json()\n    fingerprint = data['fingerprint']\n    client_ip = request.remote_addr\n    \n    if is_ip_allowed(client_ip) and fingerprint in allowed_fingerprints:\n        return jsonify({"status": "allowed"}), 200\n    else:\n        return jsonify({"status": "denied"}), 403\n\ndef is_ip_allowed(ip):\n    # Check if the IP is in one of the allowed subranges\n    from ipaddress import ip_address, ip_network\n    \n    for network in allowed_ips:\n        if ip_address(ip) in ip_network(network):\n            return True\n    return False\n\nif __name__ == '__main__':\n    app.run(debug=True)