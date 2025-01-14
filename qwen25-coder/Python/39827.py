def recommend_products(user_id, user_similarities, product_purchases):\n    # Get products bought by this user\n    owned_product_ids = set(product_purchases.loc[user_id])\n    \n    # Find similar users\n    most_similars = user_similarities[user_id].sort_values(ascending=False).index[1:]  # Exclude self\n\n    # Collect all recommended items from similar users\n    recommendations = {}\n    for similar_user in most_similars:\n        similar_owned_products = set(product_purchases.loc[similar_user])\n        not_shared_products = similar_owned_products - owned_product_ids\n        if len(not_shared_products) > 0:\n            for product_id in not_shared_products:\n                if product_id in recommendations:\n                    recommendations[product_id] += user_similarities[user_id][similar_user]\n                else:\n                    recommendations[product_id] = user_similarities[user_id][similar_user]\n\n    # Sort and return recommended products\n    return sorted(recommendations, key=recommendations.get, reverse=True)\n\nrecommended_products_for_user_1 = recommend_products(1, similarity_df, user_product_matrix)\nprint(f"Recommended products for User 1: {recommended_products_for_user_1}")