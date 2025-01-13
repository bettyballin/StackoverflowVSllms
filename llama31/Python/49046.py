def find_similar_users(user_hashes, num_neighbors):\n    similar_users = []\n    for user_id, hashes in user_hashes.items():\n        similarity = len(set(hashes) & set(user_hashes[user_id]))\n        similar_users.append((user_id, similarity))\n    similar_users.sort(key=lambda x: x[1], reverse=True)\n    return similar_users[:num_neighbors]\n\nsimilar_users = find_similar_users({x_hashes: 'X', y_hashes: 'Y', z_hashes: 'Z'}, 2)\nprint(similar_users)  # [(Z, 8), (Y, 6)]