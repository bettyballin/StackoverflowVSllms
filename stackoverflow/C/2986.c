int iNumFilled1 = scanf_s("%s", arr);\nint iNumFilled2 = scanf_s("%s", arr, _countof(arr));\nassert(iNumFilled1 == 0);\nassert(iNumFilled2 == 1);