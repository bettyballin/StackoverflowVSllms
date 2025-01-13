public static int InsertArtist(Artist artist)\n{\n    if (artist == null)\n        throw new ArgumentNullException("artist");\n\n    int artistid = 0;\n    using (TransactionScope scope = new TransactionScope())\n    {\n        // insert the master Artist\n        /* \n           we plug the artistid variable into \n           any child instance where ArtistID is required\n        */\n        artistid = SiteProvider.Artist.InsertArtist(new ArtistDetails(\n        0,\n        artist.BandName,\n        artist.DateAdded));\n\n        // insert the child ArtistArtistGenre\n        artist.ArtistArtistGenres.ForEach(item =>\n        {\n            var artistartistgenre = new ArtistArtistGenreDetails(\n                0,\n                artistid,\n                item.ArtistGenreID);\n            SiteProvider.Artist.InsertArtistArtistGenre(artistartistgenre);\n        });\n\n        // insert the child ArtistLink\n        artist.ArtistLinks.ForEach(item =>\n        {\n            var artistlink = new ArtistLinkDetails(\n                0,\n                artistid,\n                item.LinkURL);\n            SiteProvider.Artist.InsertArtistLink(artistlink);\n        });\n\n        // insert the child ArtistProfile\n        artist.ArtistProfiles.ForEach(item =>\n        {\n            var artistprofile = new ArtistProfileDetails(\n                0,\n                artistid,\n                item.Profile);\n            SiteProvider.Artist.InsertArtistProfile(artistprofile);\n        });\n\n        // insert the child FestivalArtist\n        artist.FestivalArtists.ForEach(item =>\n        {\n            var festivalartist = new FestivalArtistDetails(\n                0,\n                item.FestivalID,\n                artistid,\n                item.AvailableFromDate,\n                item.AvailableToDate,\n                item.DateAdded);\n            SiteProvider.Festival.InsertFestivalArtist(festivalartist);\n        });\n        BizObject.PurgeCacheItems(String.Format(ARTISTARTISTGENRE_ALL_KEY, String.Empty, String.Empty));\n        BizObject.PurgeCacheItems(String.Format(ARTISTLINK_ALL_KEY, String.Empty, String.Empty));\n        BizObject.PurgeCacheItems(String.Format(ARTISTPROFILE_ALL_KEY, String.Empty, String.Empty));\n        BizObject.PurgeCacheItems(String.Format(FESTIVALARTIST_ALL_KEY, String.Empty, String.Empty));\n        BizObject.PurgeCacheItems(String.Format(ARTIST_ALL_KEY, String.Empty, String.Empty));\n\n        // commit the entire transaction - all or nothing\n        scope.Complete();\n    }\n    return artistid;\n}