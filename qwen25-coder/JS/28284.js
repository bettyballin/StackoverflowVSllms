connection.send($msg({to: 'recipient@example.com', type: 'chat'}).c("body").t("Hello!"));\n     \n     connection.addHandler(onMessage, null, "message", null, null,  null);\n\n     function onMessage(msg) {\n         const from = msg.getAttribute('from');\n         const body = msg.getElementsByTagName('body')[0];\n         \n         console.log(`Message from ${from}: ${Strophe.getText(body)}`);\n         \n         return true;\n     }