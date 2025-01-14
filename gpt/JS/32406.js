// main.js\n    const { app, BrowserWindow } = require('electron');\n    const path = require('path');\n\n    function createWindow () {\n      const mainWindow = new BrowserWindow({\n        width: 800,\n        height: 600,\n        webPreferences: {\n          preload: path.join(__dirname, 'preload.js')\n        }\n      });\n\n      mainWindow.loadFile('index.html');\n    }\n\n    app.on('ready', createWindow);