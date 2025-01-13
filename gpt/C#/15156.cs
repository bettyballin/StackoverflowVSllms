public static void GetQuesID(string quesText)\n{\n    ExamineDataContext dc = new ExamineDataContext();\n    var matchedques = from q in dc.GetTable<Question>()\n                      where q.QuestionText.Contains(quesText)\n                      select new\n                      {\n                          q.QuestionID\n                      };\n\n    foreach (var element in matchedques)\n    {\n        MessageBox.Show(element.QuestionID.ToString()); // Display the GUID correctly\n    }\n\n    try\n    {\n        Guid g = Guid.NewGuid();\n        Table<DateLastUsed> dlused = Repository.GetDateLastUsedTable();\n        DateLastUsed dlu = new DateLastUsed();\n\n        foreach (var element in matchedques)\n        {\n            Guid convQuesGuid = element.QuestionID; // Extract the GUID directly\n            dlu.DLUID = g;\n            dlu.QuestionID = convQuesGuid;\n            dlu.DateLastUsed1 = DateTime.Now;\n\n            dlused.InsertOnSubmit(dlu);\n        }\n\n        dlused.Context.SubmitChanges();\n    }\n    catch (Exception ex)\n    {\n        throw ex;\n    }\n}