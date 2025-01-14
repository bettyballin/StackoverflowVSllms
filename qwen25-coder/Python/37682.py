from surprise import Dataset, Reader, KNNBasic\nfrom surprise.model_selection import train_test_split\nfrom surprise import accuracy\n\n# Load data from an internal dataset (e.g., MovieLens 100k)\ndata = Dataset.load_builtin('ml-100k')\n\n# Define the split ratio and perform the actual split\ntrainset, testset = train_test_split(data, test_size=0.25)\n\n# Define a NearestNeighbors algorithm with KNNBasic class\nsim_options = {'name': 'pearson_baseline', 'user_based': True}\nalgo = KNNBasic(sim_options=sim_options)\n\n# Train the algorithm on the trainset, and predict ratings for the testset\nalgo.fit(trainset)\npredictions = algo.test(testset)\n\n# Compute and print RMSE\naccuracy.rmse(predictions)