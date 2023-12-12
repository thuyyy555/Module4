<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
  <link rel="stylesheet" href="bootstrap520/css/bootstrap.min.css" />
  <link rel="stylesheet" href="datatables/css/dataTables.bootstrap5.min.css" />
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
  <style>
    a{
      text-decoration: none;
      color: white;
    }
    button:hover a{
      text-decoration: none;
      color: white;
    }
  </style>
</head>
<body>
<div class="container">
  <button type="button" class="btn btn-primary">
    <a href="?action=showFormConvert">Go to convert</a>
  </button>
  <form class="d-flex" method="post" action="?action=search">
    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" name="txtSearch">
    <button class="btn btn-outline-success" type="submit">Search</button>
  </form>
  <div class="row">
    <div class="col-lg-12">
      <table id="tableCustomer" class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
          <th>ID File</th>
          <th>Tên File</th>
          <th>Ngày lưu</th>
          <th>Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="cfile" items="${list}">
          <tr>
            <td><c:out value="${cfile.id}"></c:out></td>
            <td><c:out value="${cfile.fileName}"></c:out></td>
            <td><c:out value="${cfile.date}"></c:out></td>
            <td>
              <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal"
                      onclick="passIdToModal(${cfile.id})">
                Delete
              </button>
            </td>
              <%--                        <td>--%>
              <%--                            <button type="button" class="btn btn-primary">--%>
              <%--                                <a href="/employee?action=showFormUpdate&update_id=${employee.maNhanVien}">Update</a>--%>
              <%--                            </button>--%>
              <%--                        </td>--%>
          </tr>
        </c:forEach>
        </tbody>
      </table>
      <form method="post" action="?action=delete">
        <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
          <div class="modal-dialog">
            <div class="modal-content">
              <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Thông báo</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
              </div>
              <div class="modal-body">
                Bạn có xác nhận muốn xóa ?
              </div>
              <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary">Xác nhận</button>
              </div>
              <input type="hidden" id="modalIdInput" name="id">
            </div>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>

<script src="jquery/jquery-3.5.1.min.js"></script>
<script src="datatables/js/jquery.dataTables.min.js"></script>
<script src="datatables/js/dataTables.bootstrap5.min.js"></script>
<script>
  $(document).ready(function() {
    $('#tableCustomer').dataTable( {
      "dom": 'lrtip',
      "lengthChange": false,
      "pageLength": 13
    } );
  } );
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
        crossorigin="anonymous"></script>
<script>
  function passIdToModal(id) {
    document.getElementById('modalIdInput').value = id;
  }
</script>
</body>
</html>



