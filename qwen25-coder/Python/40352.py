import numpy as np\nfrom scipy.sparse import csr_matrix\nfrom sklearn.neighbors import NearestNeighbors\n\n# Function to create a sparse rating matrix\ndef create_rating_matrix(num_users, num_movies, ratings_data):\n    rows, cols, data = [], [], []\n    for user_id, movie_ratings in enumerate(ratings_data):\n        for movie_id, rating in movie_ratings.items():\n            rows.append(user_id)\n            cols.append(movie_id)\n            data.append(rating)\n    return csr_matrix((data, (rows, cols)), shape=(num_users, num_movies))\n\n# Example ratings data\nratings = [\n    {0: 9, 1: 5, 3: 1, 4: 1, 7: 5},  # User Xm\n    {2: 4, 3: 6, 5: 1, 8: 8},       # User Ym\n    {0: 9, 2: 6, 3: 4, 8: 7}        # User Zf\n]\n\nnum_users = len(ratings)\nnum_movies = max(max(movie_id for movie_id in user_ratings) for user_ratings in ratings) + 1\n\n# Convert to sparse matrix\nrating_matrix = create_rating_matrix(num_users, num_movies, ratings)\n\n# Use NearestNeighbors from sklearn to find similar users\nmodel = NearestNeighbors(metric='cosine', algorithm='brute')\nmodel.fit(rating_matrix)\n\n# Find the nearest neighbors for each user (approximate match)\ndistances, indices = model.kneighbors(rating_matrix)\n\nprint("Distances:\n", distances)\nprint("Indices of nearest neighbors:\n", indices)