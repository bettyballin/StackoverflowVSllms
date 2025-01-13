using StackExchange.Redis;\n\n// Connect to the Redis server\nConnectionMultiplexer redis = ConnectionMultiplexer.Connect("localhost");\n\n// Get a reference to the database\nIDatabase db = redis.GetDatabase();\n\n// Set and get a string value from the cache\nawait db.StringSetAsync("sampleKey", "Hello, Redis!");\nstring cachedValue = await db.StringGetAsync("sampleKey");