<!DOCTYPE html>
<html>
<head>
  <title>Registration Form</title>
</head>
<body>
<h2>Student Registration Form</h2>
<form action="RegistrationForm" name="formDangKy" method="GET">
  <label for="firstName">First name:</label><br>
  <input type="text" id="firstName" name="firstName"><br>

  <label for="lastName">Last name:</label><br>
  <input type="text" id="lastName" name="lastName"><br>

  <label for="dob">Date of birth:</label><br>
  <input type="text" id="dob" name="dob"><br>

  <label for="email">Email:</label><br>
  <input type="email" id="email" name="email"><br>

  <label for="mobileNumber">Mobile number:</label><br>
  <input type="text" id="mobileNumber" name="mobileNumber"><br>

  <label for="gender">Gender:</label><br>
  <input type="radio" id="male" name="gender" value="Male"> Male
  <input type="radio" id="female" name="gender" value="Female"> Female<br>

  <label for="address">Address:</label><br>
  <textarea id="address" name="address"></textarea><br>

  <label for="city">City:</label><br>
  <input type="text" id="city" name="city"><br>

  <label for="pinCode">Pin code:</label><br>
  <input type="text" id="pinCode" name="pinCode"><br>

  <label for="state">State:</label><br>
  <input type="text" id="state" name="state"><br>

  <label for="country">Country:</label><br>
  <input type="text" id="country" name="country" value="India" readonly><br>

  <label for="hobbies">Hobbies:</label><br>
  <input type="checkbox" name="hobbies" value="Drawing"> Drawing
  <input type="checkbox" name="hobbies" value="Singing"> Singing
  <input type="checkbox" name="hobbies" value="Dancing"> Dancing
  <input type="checkbox" name="hobbies" value="Sketching"> Sketching
  <input type="checkbox" name="hobbies" value="Others"> Others<br>

  <label>Qualifications:</label><br>
  <table border="1">
    <tr>
      <th>Examination</th>
      <th>Board</th>
      <th>Percentage</th>
      <th>Year of Passing</th>
    </tr>
    <tr>
      <td>Class X</td>
      <td><input type="text" name="boardClassX"></td>
      <td><input type="text" name="percentageClassX"></td>
      <td><input type="text" name="yearClassX"></td>
    </tr>
    <tr>
      <td>Class XII</td>
      <td><input type="text" name="boardClassXII"></td>
      <td><input type="text" name="percentageClassXII"></td>
      <td><input type="text" name="yearClassXII"></td>
    </tr>
    <tr>
      <td>Graduation</td>
      <td><input type="text" name="boardGraduation"></td>
      <td><input type="text" name="percentageGraduation"></td>
      <td><input type="text" name="yearGraduation"></td>
    </tr>
    <tr>
      <td>Masters</td>
      <td><input type="text" name="boardMasters"></td>
      <td><input type="text" name="percentageMasters"></td>
      <td><input type="text" name="yearMasters"></td>
    </tr>
  </table>

  <label for="courseApplies">Course applies for:</label><br>
  <input type="radio" name="courseApplies" value="BCA"> BCA
  <input type="radio" name="courseApplies" value="B.Com"> B.Com
  <input type="radio" name="courseApplies" value="B.Sc"> B.Sc
  <input type="radio" name="courseApplies" value="B.A"> B.A<br>

  <input type="submit" value="Submit">
  <input type="reset" value="Reset">
</form>
</body>
</html>
