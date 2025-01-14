from flask import Flask, request, render_template_string\n\napp = Flask(__name__)\n\n@app.route('/')\ndef index():\n    request_uri = request.url\n    movie_value = f"flash.swf?{request_uri.split('/')[-1]}"\n    return render_template_string('''\n    <!DOCTYPE html>\n    <html lang="en">\n    <head>\n        <meta charset="UTF-8">\n        <title>Flash Object</title>\n    </head>\n    <body>\n        <object classid="clsid:XXXXXXXXX-YYYY-ZZZZ-AAAA-BBBBBBBBBB" \n                codebase="http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=7,0,0,0" \n                width="100%" height="100%" id="main" align="middle">\n            <param name="allowScriptAccess" value="all" />\n            <param name="flashvars" value="" />\n            <param name="movie" value="{{ movie_value }}" />\n            <param name="loop" value="false" />\n            <param name="quality" value="high" />\n            <param name="bgcolor" value="#eeeeee" />\n            <embed src="{{ movie_value }}" \n                   loop="false" quality="high" bgcolor="#eeeeee" \n                   width="100%" height="100%" name="main" align="middle"\n                   allowScriptAccess="all" type="application/x-shockwave-flash" \n                   pluginspage="http://www.macromedia.com/go/getflashplayer" />\n        </object>\n    </body>\n    </html>\n    ''', movie_value=movie_value)\n\nif __name__ == '__main__':\n    app.run(debug=True)