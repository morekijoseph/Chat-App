Project Structure 
ChatApp/
├── Source Packages/
│   └── chatapp/
│       ├── ChatApp.java     # Main entry point (console application)
│       └── Login.java       # Core logic: validation, registration, login
└── Test Packages/
    └── chatapp/
        └── ChatAppTest.java # JUnit tests covering Login.java
        Features
       -username Validation(checkUserName)
       . Must contain an underscore (_)
       . Must be 5 characters or fewer
       .Example valid:kyl-1
      - Password Complexity Validation(CheckPasswordComplexity)
       .Must include at least one uppercase letter
       .Must include at least one digit
       .Must include at least one special character
       .Must meet a minimum length 
       .Example valid:Moreki@00
       -Cellphone Number Validation(CellphoneNumber)
       .Empty string is accepted
       .Otherwise must start with +27 and be exactly 12 characters
       .Example valid:+27 812557129
       -Login (loginUser)
       .Compares stored vs. entered username and password
       .Returns true/false based on match
       -Login Status Message (returnLoginStatus)
       .On success: "Welcome [First] [Last], it is great to see you again!"
