protected void Page_Load(object sender, EventArgs e)\n{\n    if (!IsPostBack)\n    {\n        // Get query string parameter "promo"\n        string promoCode = Request.QueryString["promo"];\n        \n        if (!string.IsNullOrEmpty(promoCode))\n        {\n            // Fetch data from the database based on promo code\n            var promoData = FetchPromotionDataFromDatabase(promoCode);\n            \n            // Store data in a hidden field or render it directly to JavaScript\n            HiddenField1.Value = JsonConvert.SerializeObject(promoData);\n        }\n    }\n}\n\nprivate object FetchPromotionDataFromDatabase(string promoCode)\n{\n    // Database logic here - retrieve promotion details using promoCode\n    // For example, return an anonymous object containing promotion details\n    return new { Title = "Summer Sale", Description = "Get 20% off with code SUMMER19!" };\n}