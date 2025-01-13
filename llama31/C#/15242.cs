public class CustomListItem\n{\n    public string Text { get; set; }\n    public string Value { get; set; }\n}\n\n// ...\n\nList<CustomListItem> users = new List<CustomListItem>();\nforeach (SubscriptionUser su in subscriptionDetails.UserList)\n{\n    users.Add(new CustomListItem { Text = su.FirstName + " " + su.LastName, Value = su.EmailAddress });\n}\nddlPrimaryContact.DataSource = users;\nddlPrimaryContact.DataTextField = "Text";\nddlPrimaryContact.DataValueField = "Value";\nddlPrimaryContact.DataBind();