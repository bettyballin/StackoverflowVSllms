using Microsoft.SharePoint;\n\n// Get the current site\nSPSite currentSite = SPContext.Current.Site;\n\n// Create a new alert for the site\nSPAlert newAlert = new SPAlert(currentSite);\n\n// Set the alert properties\nnewAlert.EventType = SPEventType.All;\nnewAlert.Frequency = SPAlertFrequency.Daily;\nnewAlert.Title = "Daily Summary Alert for " + currentSite.Title;\nnewAlert.AlertTemplate = SPAlertTemplateType.GenericList;\nnewAlert.DeliveryChannels = SPAlertDeliveryChannels.Email;\n\n// Add the site owner as the alert recipient\nnewAlert.AddRecipient(currentSite.Owner);\n\n// Save the alert\nnewAlert.Update();