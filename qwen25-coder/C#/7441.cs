using (SPSite site = new SPSite(siteUrl)) {\n       using (SPWeb web = site.OpenWeb()) {\n           // Work with the web object here\n       }\n   }