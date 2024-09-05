<!DOCTYPE html>
<html>
<head>
  <title>Send Email</title>
</head>
<body>
<h2>Send Email with Attachment</h2>
<form action="sendEmail" method="post" enctype="multipart/form-data">
  <p>Recipient: <input type="email" name="recipient" required /><br/></p>
  <p>Subject: <input type="text" name="subject" required /><br/></p>
  <p>Message: <textarea name="message" rows="5" required></textarea><br/></p>
  <p>Attachment: <input type="file" name="attachment" /><br/></p>
  <input type="submit" value="Send" />
</form>
</body>
</html>
