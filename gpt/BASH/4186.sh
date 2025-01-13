@ECHO OFF\n:Start\nSET /P UserInput=Please Enter a Number: \n\n:: Check if the input is empty\nIF "%UserInput%"=="" (\n    ECHO Input is empty. Please enter a non-negative integer.\n    GOTO Start\n)\n\n:: Check if the input contains only digits\nFOR /L %%i IN (0,1,9) DO (\n    SET UserInput=!UserInput:%%i=!\n)\n\nIF NOT "%UserInput%"=="" (\n    ECHO Invalid input. Please enter a non-negative integer.\n    GOTO Start\n)\n\nECHO You entered a valid number: %UserInput%\n:: Your additional code can go here\n\nPAUSE