public class HomeController : Controller\n{\n    public ActionResult StoreLocation(double latitude, double longitude)\n    {\n        // Optionally convert the coordinates to a readable address using reverse geocoding API\n        var location = GetAddressFromCoordinates(latitude, longitude);\n\n        // Storing the location in session\n        Session["UserLocation"] = location;\n\n        return Json(new { success = true });\n    }\n\n    private string GetAddressFromCoordinates(double latitude, double longitude)\n    {\n        var apiKey = "YOUR_GOOGLE_MAPS_API_KEY";\n        using (var client = new WebClient())\n        {\n            var addressApiResponse = client.DownloadString($"https://maps.googleapis.com/maps/api/geocode/json?latlng={latitude},{longitude}&key={apiKey}");\n            dynamic locationData = Newtonsoft.Json.JsonConvert.DeserializeObject(addressApiResponse);\n            return locationData.results[0].formatted_address;\n        }\n    }\n}