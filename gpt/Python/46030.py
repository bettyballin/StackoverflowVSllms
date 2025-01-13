import pandas as pd\nfrom sklearn.feature_extraction.text import TfidfVectorizer\nfrom sklearn.cluster import KMeans\n\n# Sample product descriptions\nproducts = [\n    "Seagate Hard Drive 500Go",\n    "Seagate Hard Drive 120Go for laptop",\n    "Seagate Barracuda 7200.12 ST3500418AS 500GB 7200 RPM SATA 3.0Gb/s Hard Drive",\n    "New and shiny 500Go hard drive from Seagate",\n    "Seagate Barracuda 7200.12",\n    "Seagate FreeAgent Desk 500GB External Hard Drive Silver 7200RPM USB2.0 Retail",\n    "GE Spacemaker Laundry",\n    "Mazda3 2010",\n    "Mazda3 2009 2.3L"\n]\n\n# Create a TF-IDF vectorizer\nvectorizer = TfidfVectorizer(stop_words='english')\nX = vectorizer.fit_transform(products)\n\n# Perform K-Means clustering\nkmeans = KMeans(n_clusters=3, random_state=42)\nkmeans.fit(X)\n\n# Assign products to clusters\nclusters = kmeans.predict(X)\n\n# Create a DataFrame to view the results\nproduct_clusters = pd.DataFrame({'Product': products, 'Cluster': clusters})\nprint(product_clusters)