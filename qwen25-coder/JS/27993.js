// In your background script\n    function sendNativeMessage() {\n        const myPort = browser.runtime.connectNative("native-host");\n        myPort.onMessage.addListener((response) => {\n            console.log("Received: " + response);\n        });\n        myPort.onDisconnect.addListener(() => {\n            if (browser.runtime.lastError) {\n                console.error(`Failed to connect to native host: ${browser.runtime.lastError.message}`);\n            } else {\n                console.info("Disconnected");\n            }\n        });\n\n        // Send a message to the native app\n        myPort.postMessage({ greeting: "hello" });\n    }\n\n    sendNativeMessage();