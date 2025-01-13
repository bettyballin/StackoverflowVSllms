Dim vehicles = From v In doc...<Vehicle> _\n               Let mile = If((From x In v.<ItemSpecific>.<NameValueList> Where x.<Name>.Value = "Mileage" Select x.<Value>.Value).Any(), \n                             (From x In v.<ItemSpecific>.<NameValueList> Where x.<Name>.Value = "Mileage" Select x.<Value>.Value).Single(), \n                             String.Empty) _\n               Let year = If((From z In v.<ItemSpecific>.<NameValueList> Where z.<Name>.Value = "Year" Select z.<Value>.Value).Any(), \n                             (From z In v.<ItemSpecific>.<NameValueList> Where z.<Name>.Value = "Year" Select z.<Value>.Value).Single(), \n                             String.Empty) _\n               Select New Vehicle With {.Name = v.<Item>.<Name>.Value, .Maker = v.<Item>.<Maker>.Value, .Color = v.<Item>.<Color>.Value, .Mileage = mile, .Year = year}