from flask import Flask, render_template\n\napp = Flask(__name__)\n\n@app.route('/articles/<article_id>')\ndef show_article(article_id):\n    # Logic to fetch article from database\n    article = get_article_from_db(article_id)\n    return render_template('article.html', article=article)\n\n@app.route('/galleries/<gallery_id>')\ndef show_gallery(gallery_id):\n    # Logic to fetch gallery from database\n    gallery = get_gallery_from_db(gallery_id)\n    return render_template('gallery.html', gallery=gallery)\n\ndef get_article_from_db(article_id):\n    # Simulated database fetch\n    return {"id": article_id, "title": "Sample Article", "content": "This is an article."}\n\ndef get_gallery_from_db(gallery_id):\n    # Simulated database fetch\n    return {"id": gallery_id, "title": "Sample Gallery", "images": []}\n\nif __name__ == '__main__':\n    app.run(debug=True)