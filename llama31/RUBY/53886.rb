p = Post.find(1)\np.comments.reload\np.comments.size # should return the correct count