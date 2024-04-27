# EmaClima


Develop a system to query weather information, create user accounts, and facilitate user login. It will integrate real-world data and user management functionalities

Entity

1. **Username:**
   1. **Required:** Yes
   1. **Format Conditions:** Alphanumeric characters only (letters and numbers), between 3 and 20 characters in length.
1. **Email:**
   1. **Required:** Yes
   1. **Format Conditions:** Must be a valid email format (e.g., example@example.com).
1. **Password:**
   1. **Required:** Yes
   1. **Format Conditions:** Must be at least 8 characters long, containing at least one uppercase letter, one lowercase letter, one number, and one special character.
1. **Date of Birth:**
   1. **Required:** No
   1. **Format Conditions:** Must be in YYYY-MM-DD format if provided.
1. **Country:**
   1. **Required:** No
   1. **Format Conditions:** Any text format, maximum length of 50 characters.


Use Case List:

1. **Query Temperature:**
   1. **Description:** Users can input a location to retrieve the current temperature.
   1. **Actors:** All users
   1. **Preconditions:** System must be online and connected to a weather API.
   1. **Basic Flow:**
      1. User enters a location.
      1. System queries weather data for the specified location.
      1. System retrieves and displays the current temperature to the user.
   1. **Alternate Flows:**

      1. If the location is invalid or not found, the system prompts the user to enter a valid location.
      1. If there is an error in retrieving the temperature data, the system displays an error message to the user.

1. **Create User Account:**
   1. **Description:** New users can register for an account to access
   1. **Preconditions:** None
   1. **Basic Flow:**
      1. User selects the "Sign Up" option.
      1. User fills out the registration form with required details (e.g., username, email, password).
      1. System validates the input and creates a new user account if the email is unique.
      1. User account is created.
   1. **Alternate Flows:**

      1. If the provided email is already associated with an existing account, the system prompts the user to log in or use a different email.
      1. If there is an error during account creation (e.g., database connection failure), the system displays an error message to the user.

1. **User Login:**
   1. **Description:** Registered users can log in to their accounts to access personalized features and settings.
   1. **Actors:** Registered users
   1. **Preconditions:** User must have a registered account.
   1. **Basic Flow:**
      1. User enters their username/email and password.
      1. System validates the credentials.
      1. If the credentials are valid, the system logs the user in and redirects them to the dashboard.
   1. **Alternate Flows:**

      1. If the entered credentials are incorrect, the system prompts the user to enter valid credentials.
      1. If there is an error during the login process (e.g., authentication failure), the system displays an error message to the user.

1. **Modify User Data:**
   1. **Description:** Registered users can modify their account information, such as username, password, and email.
   1. **Actors:** Registered users
   1. **Preconditions:** User must be logged in.
   1. **Basic Flow:**
      1. User navigates to the account settings section.
      1. User selects the option to modify account information.
      1. User makes changes to the desired fields (e.g., username, password, email).
      1. System validates the modified data, ensuring the email remains unique among all users.
      1. If the data is valid, the system updates the user's account information.
   1. **Alternate Flows:**

      1. If the modified email already exists in the system, the system prompts the user to choose a different email.
      1. If there is an error during the modification process (e.g., database update failure), the system displays an error message to the user.

1. **Get All Users:**
   1. **Description:** Administrators can retrieve a list of all registered users.
   1. **Actors:** Administrators
   1. **Preconditions:** User must be logged in as an administrator.
   1. **Basic Flow:**
      1. Administrator navigates to the user management section.
      1. System retrieves the list of all registered users.
      1. System displays the list of users to the administrator.
   1. **Alternate Flows:**

      1. If there are no registered users in the system, the system displays a message indicating that there are no users to display.
      1. If there is an error retrieving the user data (e.g., database query failure), the system displays an error message to the administrator.
