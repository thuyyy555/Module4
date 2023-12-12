<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<form method="post" action="?action=convert" enctype="multipart/form-data">
  <div class="mb-3">
    <label for="idFile" class="form-label">ID File</label>
    <input type="text" class="form-control" id="idFile" name="idFile">
  </div>
  <div class="mb-3">
    <label for="fileName" class="form-label">Tên File</label>
    <input type="text" class="form-control" id="fileName" name="fileName">
  </div>
  <div class="mb-3">
    <label for="date" class="form-label">Nhập ngày</label>
    <input type="date" class="form-control" id="date" name="date">
  </div>
  <div class="mb-3">
    <label for="filePath" class="form-label">Đường dẫn</label>
    <input type="file" class="form-control" id="filePath" name="filePath">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>

