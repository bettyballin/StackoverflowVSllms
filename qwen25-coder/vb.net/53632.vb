Dim PostsEnum = From BlogPost In XMLSource.Descendants("item")\n                Let pubDateElement = BlogPost.Element("pubDate")\n                Let sourceElement = BlogPost.Element("source")\n                Order By DateTime.Parse(pubDateElement?.Value ?? "1/1/1900 12:00 AM") Descending\n                Select New Post() With {\n                    .Title = BlogPost.Element("title")?.Value,\n                    .Link = BlogPost.Element("link")?.Value,\n                    .Description = BlogPost.Element("description")?.Value,\n                    .AuthorText = BlogPost.Element("author")?.Value,\n                    .Category = (From tag In BlogPost.Descendants("category")\n                                  Select If(tag.FirstNode IsNot Nothing, tag.FirstNode.ToString(), String.Empty)).ToList(),\n                    .PubDate = If(pubDateElement IsNot Nothing, DateTime.Parse(pubDateElement.Value), DateTime.MinValue),\n                    .GUID = BlogPost.Element("guid")?.Value,\n                    .Source = sourceElement?.Value\n                }