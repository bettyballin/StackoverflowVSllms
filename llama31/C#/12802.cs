UriBuilder builder = new UriBuilder("http://www.travel.com");\nbuilder.Path = $"/{country}/{hotel}";\nstring url = builder.ToString();