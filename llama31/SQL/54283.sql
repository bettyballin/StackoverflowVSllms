UPDATE cluster_nodes\nSET isMaster = CASE \n    WHEN nodeID = ? AND (NOT EXISTS (SELECT 1 FROM cluster_nodes WHERE isMaster = TRUE AND lastTimestamp > NOW() - INTERVAL '2*X seconds') \n    OR NOT EXISTS (SELECT 1 FROM cluster_nodes WHERE isMaster = TRUE)) THEN TRUE\n    ELSE FALSE\nEND,\nlastTimestamp = CASE \n    WHEN nodeID = ? AND (NOT EXISTS (SELECT 1 FROM cluster_nodes WHERE isMaster = TRUE AND lastTimestamp > NOW() - INTERVAL '2*X seconds') \n    OR NOT EXISTS (SELECT 1 FROM cluster_nodes WHERE isMaster = TRUE)) THEN NOW()\n    ELSE lastTimestamp\nEND\nWHERE nodeID = ? OR isMaster = TRUE;