from flask import Flask, Response, render_template_string\nfrom time import sleep\n\napp = Flask(__name__)\n\n@app.route('/')\ndef index():\n    return render_template_string('''\n        <!doctype html>\n        <html>\n        <head>\n            <title>Import Progress</title>\n        </head>\n        <body>\n            <h1>Import Progress</h1>\n            <div id="progress"></div>\n            <script>\n                var eventSource = new EventSource("/stream");\n                eventSource.onmessage = function(event) {\n                    var newElement = document.createElement("div");\n                    newElement.innerHTML = event.data;\n                    document.getElementById("progress").appendChild(newElement);\n                };\n            </script>\n        </body>\n        </html>\n    ''')\n\n@app.route('/stream')\ndef stream():\n    def generate():\n        items = ["item1", "item2", "item3"]\n        for item in items:\n            # Simulate import operation\n            sleep(1)  # Simulate time taken for import\n            \n            # Yield a message to the client\n            yield f"data: Successfully imported: {item}\n\n"\n    \n    return Response(generate(), mimetype="text/event-stream")\n\nif __name__ == '__main__':\n    app.run(debug=True, threaded=True)