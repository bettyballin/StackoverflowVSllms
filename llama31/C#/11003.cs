writer.WriteAttributeString("userid", dr["userid"] != DBNull.Value ? dr["userid"].ToString() : string.Empty);