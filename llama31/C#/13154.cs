public class CustomSessionStateProvider : SessionStateStoreProviderBase\n{\n    // ...\n\n    public override SessionStateStoreData GetItem(HttpContext context, string id)\n    {\n        // Load session data from database only when needed\n        // ...\n    }\n}