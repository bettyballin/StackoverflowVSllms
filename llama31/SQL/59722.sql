WITH ranked AS (\n  SELECT \n    PatientVisitID,\n    ROW_NUMBER() OVER (PARTITION BY PatientID ORDER BY TreatAuthDate DESC) AS TreatAuthRank,\n    ROW_NUMBER() OVER (PARTITION BY PatientID ORDER BY HIPAADate DESC) AS HIPAARank,\n    ROW_NUMBER() OVER (PARTITION BY PatientID ORDER BY DrugTestDate DESC) AS DrugTestRank\n  FROM tblSignature\n  WHERE PatientID = 12345\n)\nSELECT \n  MAX(CASE WHEN TreatAuthRank = 1 THEN PatientVisitID END) AS TreatAuthPatientVisitID,\n  MAX(CASE WHEN HIPAARank = 1 THEN PatientVisitID END) AS HIPAAPatientVisitID,\n  MAX(CASE WHEN DrugTestRank = 1 THEN PatientVisitID END) AS DrugTestPatientVisitID\nFROM ranked