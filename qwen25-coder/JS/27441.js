// Add shards to MongoDB cluster\nsh.addShard("shard1/hostname1:27018")\nsh.addShard("shard2/hostname2:27019")\n\n// Enable sharding on a specific database\ndb.adminCommand({enableSharding: "myDatabase"})\n\n// Shard a collection based on an indexed field\ndb.adminCommand({shardCollection: "myDatabase.myCollection", key: { myField: 1}})