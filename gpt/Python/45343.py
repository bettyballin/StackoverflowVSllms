from flask import Flask, request, redirect, url_for\nimport os\n\napp = Flask(__name__)\nUPLOAD_FOLDER = '/path/to/upload'\napp.config['UPLOAD_FOLDER'] = UPLOAD_FOLDER\n\n@app.route('/upload', methods=['POST'])\ndef upload_file():\n    if 'files[]' not in request.files:\n        return redirect(request.url)\n    \n    files = request.files.getlist('files[]')\n    \n    for file in files:\n        if file.filename == '':\n            continue\n        file.save(os.path.join(app.config['UPLOAD_FOLDER'], file.filename))\n    \n    return 'Files successfully uploaded'\n\nif __name__ == '__main__':\n    app.run(debug=True)