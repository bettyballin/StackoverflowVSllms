// Main process file: main.js\nconst { app, BrowserWindow } = require('electron');\n\nfunction createWindow () {\n  const win = new BrowserWindow({\n    width: 800,\n    height: 600,\n    frame: false // This removes the frame (toolbars)\n  });\n\n  win.loadURL('https://example.com');\n}\n\napp.whenReady().then(createWindow);\n\napp.on('window-all-closed', () => {\n  if (process.platform !== 'darwin') {\n    app.quit();\n  }\n});\n\napp.on('activate', () => {\n  if (BrowserWindow.getAllWindows().length === 0) {\n    createWindow();\n  }\n});