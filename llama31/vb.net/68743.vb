Dim vehicles = From v In doc...<Vehicle> _\n               Let mile = (From x In v.<ItemSpecific>.<NameValueList> Where x.<Name>.Value = "Mileage" Select x.<Value>.Value).FirstOrDefault() _\n               Let year = (From z In v.<ItemSpecific>.<NameValueList> Where z.<Name>.Value = "Year" Select z.<Value>.Value).FirstOrDefault() _\n               Select New Vehicle With {.Name = v.<Item>.<Name>.Value, .Maker = v.<Item>.<Maker>.Value, .Color = v.<Item>.<Color>.Value, .Mileage = mile, .Year = year}