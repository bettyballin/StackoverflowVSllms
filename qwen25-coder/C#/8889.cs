public class TableProfileProvider : ProfileProvider {\n     // Implementation of the IProfileProvider methods\n   }\n\n   // In your code-behind, you might need to cast Profile as ProfileCommon to access properties.\n   var firstName = ((ProfileCommon)Profile).FirstName;