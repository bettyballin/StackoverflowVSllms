chrome.browserAction.onClicked.addListener((tab) => {\n  chrome.tabs.create({url: 'https://example.com'}, (newTab) => {\n    chrome.tabs.executeScript(newTab.id, {code: `\n      document.body.innerHTML += '<div style="color: red; font-size: 18px;">Hello from the injected script!</div>';\n      console.log('Script has been executed');\n    `});\n  });\n});