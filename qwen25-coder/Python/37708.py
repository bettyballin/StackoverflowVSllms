from sklearn.cluster import AgglomerativeClustering\n\ndef cluster_sklearn(num_clusters, things):\n    # Build the distance matrix as before\n    distance_matrix = build_distance_matrix(things)\n    \n    # Convert it to a compressed form as required by sklearn\n    condensed_dist_matrix = scipy.spatial.distance.squareform(distance_matrix, checks=False)\n    \n    # Perform clustering\n    clustering_model = AgglomerativeClustering(n_clusters=num_clusters, affinity='precomputed', linkage='complete')\n    cluster_ids = clustering_model.fit_predict(condensed_dist_matrix)\n    \n    # Organize things into clusters\n    clusters = {}\n    for i in range(len(things)):\n        cluster_id = cluster_ids[i]\n        if cluster_id not in clusters:\n            clusters[cluster_id] = []\n        clusters[cluster_id].append(things[i])\n    \n    return list(clusters.values())