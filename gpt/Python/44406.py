import numpy as np\nfrom datetime import datetime, timedelta\nfrom sklearn.cluster import DBSCAN\n\n# Example dates of the photos taken\nphoto_dates = [\n    "2009-01-02", "2009-01-02", "2009-01-02", "2009-01-02", "2009-01-02",\n    "2009-01-02", "2009-01-02", "2009-01-02", "2009-01-02", "2009-01-02",\n    "2009-01-02", "2009-01-02", "2009-01-02", "2009-01-02", "2009-01-02",\n    "2009-01-03", "2009-01-03", "2009-01-03", "2009-01-03", "2009-01-03",\n    "2009-01-03", "2009-01-03", "2009-01-03", "2009-01-03", "2009-01-03",\n    "2009-01-03", "2009-01-03", "2009-01-03", "2009-01-03", "2009-01-03",\n    "2009-01-04", "2009-01-04", "2009-01-04", "2009-01-04", "2009-01-04",\n    "2009-01-04", "2009-01-04", "2009-01-04", "2009-01-04", "2009-01-04",\n    "2009-01-04", "2009-01-04", "2009-01-04", \n    "2009-01-05", "2009-01-05", "2009-01-05", "2009-01-05", "2009-01-05",\n    "2009-01-05", "2009-01-05", "2009-01-05", "2009-01-05", "2009-01-05",\n    "2009-01-05", "2009-01-05", "2009-01-05", "2009-01-05", "2009-01-05",\n    "2009-01-15", "2009-01-15", "2009-01-15", "2009-01-15", "2009-01-15"\n]\n\n# Convert dates to ordinal numbers (days since year 1)\nphoto_dates_ordinal = [datetime.strptime(date, "%Y-%m-%d").toordinal() for date in photo_dates]\n\n# Reshape data for DBSCAN\nphoto_dates_array = np.array(photo_dates_ordinal).reshape(-1, 1)\n\n# DBSCAN parameters:\n# eps: maximum distance between two samples for one to be considered as in the neighborhood of the other (in days)\n# min_samples: the number of samples in a neighborhood for a point to be considered a core point\ndbscan = DBSCAN(eps=2, min_samples=3, metric='euclidean')\nclusters = dbscan.fit_predict(photo_dates_array)\n\n# Display the clusters\nevents = {}\nfor idx, cluster in enumerate(clusters):\n    if cluster not in events:\n        events[cluster] = []\n    events[cluster].append(photo_dates[idx])\n\nfor event, dates in events.items():\n    print(f"Event {event}: {dates}")