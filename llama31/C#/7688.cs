[WebGet(UriTemplate = "{category}/?numItems={numItems}", EscapeUriTemplate = true)]\npublic Atom10FeedFormatter GetFeedByCategory(string category, int numItems)