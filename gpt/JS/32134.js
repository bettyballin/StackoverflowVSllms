// Node.js example\nconst CryptoJS = require('crypto-js');\n\nfunction md5Multibyte(str) {\n    return CryptoJS.MD5(str).toString(CryptoJS.enc.Hex);\n}\n\nconsole.log(md5Multibyte("你好")); // example multibyte string