const cheerio = require('cheerio');\n\nconst $ = cheerio.load(html);\n\n$('img').each((index, img) => {\n  $(img).attr('id', `img_${index}`);\n});\n\nconsole.log($.html());