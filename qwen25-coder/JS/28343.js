<script type="text/javascript">\n    function sendData(data) {\n        const secretKey = 'your_secret_key_here'; // Should be securely stored or passed in a more secure manner\n        const jsonData = JSON.stringify(data);\n        const hmac = CryptoJS.HmacSHA256(jsonData, secretKey).toString(CryptoJS.enc.Hex);\n\n        fetch('https://yourserver.com/collect-data', {\n            method: 'POST',\n            headers: {\n                'Content-Type': 'application/json',\n                'X-HMAC': hmac\n            },\n            body: jsonData\n        })\n        .then(response => response.json())\n        .then(data => console.log('Success:', data))\n        .catch((error) => console.error('Error:', error));\n    }\n\n    // Example usage:\n    sendData({ product_id: 123, quantity: 2 });\n</script>\n<script src="https://cdnjs.cloudflare.com/ajax/libs/crypto-js/4.0.0/crypto-js.min.js"></script>