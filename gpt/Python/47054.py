from flask import Flask, request, render_template, jsonify\n     import pandas as pd\n\n     app = Flask(__name__)\n\n     @app.route('/')\n     def index():\n         return render_template('index.html')\n\n     @app.route('/upload', methods=['POST'])\n     def upload_file():\n         file = request.files['file']\n         df = pd.read_csv(file)\n         columns = df.columns.tolist()\n         return jsonify(columns)\n\n     @app.route('/map_columns', methods=['POST'])\n     def map_columns():\n         data = request.json\n         csv_columns = data['csv_columns']\n         db_columns = data['db_columns']\n         # Implement logic to map CSV columns to DB columns\n         # Example: Save mapping to session or database\n         return jsonify(status="success")\n\n     if __name__ == '__main__':\n         app.run(debug=True)