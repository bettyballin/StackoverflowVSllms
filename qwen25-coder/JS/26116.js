$.ajax({\n    async: false,\n    dataType: "json",\n    url: "http://ws.audioscrobbler.com/2.0/?method=artist.getimages&artist=" + artist + "&api_key=" + apiKey + "&format=json",\n    success: function(data) {\n        imgURL = data.images.image[1].sizes.size[0]["#text"];\n    },\n    error: function(jqXHR, textStatus, errorThrown) {\n        console.error("Error fetching data:", textStatus, errorThrown);\n    }\n});