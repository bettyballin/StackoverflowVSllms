function getJSON(URL,success){\n    var ud = 'json'+(Math.random()*100).toString().replace(/\./g,'');\n    window[ud]= function(o){\n        success&&success(o);\n    };\n    document.getElementsByTagName('body')[0].appendChild((function(){\n        var s = document.createElement('script');\n        s.type = 'text/javascript';\n        s.src = URL.replace('callback=?','callback='+ud);\n        return s;\n    })());\n}\n\ngetJSON('http://YOUR-DOMAIN.com/script.php?dataName=john&dataAge=99&callback=?',function(data){\n    var success = data.flag === 'successful';\n    if(success) {\n        alert('The POST to abc.com WORKED SUCCESSFULLY');\n    }\n});