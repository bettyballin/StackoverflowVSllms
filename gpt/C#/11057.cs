var invoiceDb = ctx.Invoices.FindOrCreate(a => a.InvoicerId == InvoicerId\n                                            && a.Number == invoiceNumber,\n                                          () => new Invoice());\ninvoiceDb.Number = invoiceNumber;