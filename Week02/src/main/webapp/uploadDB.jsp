<!DOCTYPE html>
<html>
<head>
    <title>File Upload to Database</title>
</head>
<body>
<h2>File Upload to Database (multipart/form-data)</h2>
<form method="post" action="uploadToDB" enctype="multipart/form-data">
    <p>First Name: <input type="text" name="firstName" required></p>
    <p>Last Name: <input type="text" name="lastName" required></p>
    <p>Portrait Photo: <input type="file" name="photo" accept="image/*" required></p>
    <input type="submit" value="Save">
</form>
</body>
</html>
