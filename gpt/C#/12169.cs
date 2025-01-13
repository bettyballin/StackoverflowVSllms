connection.Open();\nXmlNodeList nodeItem = rssDoc.SelectNodes("/edno23/posts/post");\n\nforeach (XmlNode xn in nodeItem)\n{\n    cmd.Parameters.Clear();\n    string msgText = xn["message"].InnerText;\n    string C = xn["user_from"].InnerText;\n    string avatar = xn["user_from_avatar"].InnerText;\n    string endhash = GetMd5Sum(msgText);\n\n    cmd.CommandText = "SELECT COUNT(*) FROM posts WHERE hash=@endhash";\n    cmd.Parameters.AddWithValue("@endhash", endhash);\n    int count = (int)cmd.ExecuteScalar();\n\n    if (count == 0) // No existing record with the same hash\n    {\n        string sql = "INSERT INTO posts([user], msg, avatar, [date], hash) VALUES(@username, @messige, @userpic, @thedate, @hash)";\n        cmd.CommandText = sql;\n        cmd.Parameters.AddWithValue("@username", C);\n        cmd.Parameters.AddWithValue("@messige", msgText);\n        cmd.Parameters.AddWithValue("@userpic", avatar);\n        cmd.Parameters.AddWithValue("@thedate", DateTime.Now); // Ensure `dt` is defined or use DateTime.Now\n        cmd.Parameters.AddWithValue("@hash", endhash);\n\n        cmd.ExecuteNonQuery(); // Executes the insert query\n        // adapter.Update(data); // Make sure `adapter` and `data` are properly defined and used if necessary\n    }\n}\n\nconnection.Close();