// In client-side code, when sending the achievement request\nconst secretKey = 'your_secret_key'; // This should be handled on your server securely\n\nfunction createHmac(data) {\n    return crypto.createHmac('sha256', secretKey).update(data).digest('hex');\n}\n\nconst requestData = JSON.stringify({ userId: 123, achievementId: 'abc' });\nconst hmac = createHmac(requestData);\n\nfetch('/api/achievement', {\n    method: 'POST',\n    headers: {\n        'Content-Type': 'application/json'\n    },\n    body: JSON.stringify({\n        data: requestData,\n        hmac: hmac\n    })\n});