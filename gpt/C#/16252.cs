public class CampaignController : Controller\n{\n    public ActionResult Redirect(string destination, string partnerid, string campaignid, string custom = null)\n    {\n        // Validate parameters\n        if (string.IsNullOrEmpty(destination) || string.IsNullOrEmpty(partnerid) || string.IsNullOrEmpty(campaignid))\n        {\n            return new HttpStatusCodeResult(HttpStatusCode.BadRequest);\n        }\n\n        // Log the access for analytics\n        // LogAccess(partnerid, campaignid, custom);\n\n        // Determine the redirect URL based on the destination\n        string redirectUrl = GetRedirectUrl(destination, campaignid, custom);\n\n        return Redirect(redirectUrl);\n    }\n\n    private string GetRedirectUrl(string destination, string campaignid, string custom)\n    {\n        // Implement your logic to determine the correct URL\n        // Example:\n        switch (destination.ToLower())\n        {\n            case "home":\n                return Url.Action("Index", "Home");\n            case "product":\n                return Url.Action("Index", "Product");\n            case "contest":\n                return Url.Action("Index", "Contest");\n            default:\n                return Url.Action("Index", "Home"); // Fallback to home\n        }\n    }\n}