var builder = new TagBuilder("img");\nbuilder.MergeAttribute("src", "/path/to/image.jpg");\nbuilder.MergeAttribute("alt", "Image alt text");\n@builder.ToString(TagRenderMode.SelfClosing)