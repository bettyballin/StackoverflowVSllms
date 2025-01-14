SELECT ...\nFROM (\n    (\n        (\n            (\n                (\n                    (\n                        (\n                            Participant AS PAR\n                        INNER JOIN Individual AS IND \n                            ON PAR.APETSID = IND.APETSID\n                        )\n                    INNER JOIN Ethnicity AS ETH \n                        ON IND.EthnicityID = ETH.ID\n                    )\n                INNER JOIN Education AS EDU \n                    ON IND.EducationID = EDU.ID\n                )\n            INNER JOIN Marital AS MAR \n                ON IND.Marital = MAR.ID\n            )\n        INNER JOIN [Participant-Probation] AS PXP \n            ON PAR.ID = PXP.ParticipantID\n        )\n    INNER JOIN Probation AS PBN \n        ON PXP.ProbationID = PBN.ID\n    )\nINNER JOIN [Class-Participant] AS CXP \n    ON PAR.ID = CXP.ParticipantID\n)\nINNER JOIN Class AS CLS \n    ON CXP.ClassID = CLS.ID\nINNER JOIN Official AS OFR \n    ON PAR.ReferringPO = OFR.ID\nINNER JOIN [Participant-Official] AS PXO \n    ON PAR.ID = PXO.ParticipantID\nINNER JOIN Official AS OFA \n    ON PXO.OfficialID = OFA.ID;