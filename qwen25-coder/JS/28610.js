// Function to toggle fullscreen\nfunction toggleFullScreen() {\n    const doc = window.document;\n    const docEl = doc.documentElement;\n\n    const requestFullScreen = docEl.requestFullscreen \n        || docEl.mozRequestFullScreen \n        || docEl.webkitRequestFullScreen \n        || docEl.msRequestFullscreen;\n\n    const cancelFullScreen = doc.exitFullscreen \n        || doc.mozCancelFullScreen \n        || doc.webkitExitFullscreen \n        || doc.msExitFullscreen;\n\n    if(!doc.fullscreenElement && !doc.mozFullScreenElement && !doc.webkitFullscreenElement) {\n        requestFullScreen.call(docEl);\n    } else {\n        cancelFullScreen.call(doc);\n    }\n}\n\n// Call this function when you need to enter fullscreen mode\ntoggleFullScreen();