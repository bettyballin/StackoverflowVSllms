public DateTime _birthDate;\nif (string.IsNullOrEmpty(datBirthDate.Text))\n    _birthDate = DateTime.MinValue;\nelse\n    _birthDate = Convert.ToDateTime(datBirthDate.Text);\ndgvSearchResults.DataSource=ConnectBLL.BLL.Person.Search(_firstName,_middleName,_lastName,_sSN,_birthDate,_applicationID,_applicationPersonID,_fuzzy);