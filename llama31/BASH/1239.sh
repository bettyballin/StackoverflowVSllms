# Send an SMS using SMSGlobal's API\ncurl -X POST \\n  https://api.smsglobal.com/http-api.php \\n  -H 'Authorization: Basic your_api_key' \\n  -d 'action=sendsms&user=your_username&password=your_password&from=your_number&to=+1234567890&text=Hello+from+Linux!'