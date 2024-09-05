<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Upload Multi-files</title>
</head>
<body>
<h2>Upload Multi-files</h2>
<form action="upload" method="post" enctype="multipart/form-data">
    <p>File #1: <input type="file" name="file1" /><br/></p>
    <p>File #2: <input type="file" name="file2" /><br/></p>
    <p>File #3: <input type="file" name="file3" /><br/></p>
    <p>File #4: <input type="file" name="file4" /><br/></p>
    <p>File #5: <input type="file" name="file5" /><br/></p>
    <input type="submit" value="Upload" />
    <input type="reset" value="Reset" />
</form>
</body>
</html>
