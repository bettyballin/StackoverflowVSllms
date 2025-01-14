Dim targetDate As DateTime = Date.Parse("1/1/2011")\n\nDim locations = From loc In dc.Locations _\n                Where loc.AltLong IsNot Nothing AndAlso loc.AltLat IsNot Nothing _\n                Select New AnnexA.Entities.AnnexALocation With {\n                    .ID = loc.ID,\n                    .Name = loc.Name, ' Assuming this is the correct field from Location table for location name\n                    .Y = loc.AltLat,\n                    .X = loc.AltLong,\n                    .Units = From ol In loc.organization_locations _\n                              Where ol.eff_date <= targetDate _\n                              Let org = dc.Organizations.FirstOrDefault(Function(o) o.ID = ol.organization_id) _\n                              Let latestName = (From oname In org.organization_names _\n                                              Where oname.eff_date <= targetDate _\n                                              Order By oname.eff_date Descending _\n                                              Select oname).FirstOrDefault() _\n                              Where latestName IsNot Nothing _\n                              Select New AnnexA.Entities.AnnexAMillitaryUnit With {\n                                  .ID = ol.Organization.ID,\n                                  .Name = latestName.name,\n                                  .IconPath = latestName.icon\n                              }\n                }\n\n' Enumerate or process the 'locations' to ensure query execution\nFor Each location In locations\n    Console.WriteLine(location.Name)\nNext