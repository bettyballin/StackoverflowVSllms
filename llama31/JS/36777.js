const canvas = document.getElementById('canvas');\nconst ctx = canvas.getContext('2d');\nctx.drawImage(document.body, 0, 0, canvas.width, canvas.height);\nconst screenshot = canvas.toDataURL();