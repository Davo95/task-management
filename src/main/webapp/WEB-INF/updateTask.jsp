<%@ page import="am.itspace.userbook.model.Book" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Update Book</title>
</head>
<body>
<% String msg = (String) session.getAttribute("msg"); %>
<% Book book = (Book) request.getAttribute("book"); %>
<% if (msg != null && !"".equals(msg)) { %>
<span style="color: orangered"><%=msg%></span>
<%
        session.removeAttribute("msg");
    } %>
<h1>Add Book</h1> <a href="/logout"></a>
<form action="/updateBook" method="post" enctype="multipart/form-data">
    <input type="hidden" name="id" value="<%=book.getId()%>">
    title: <input type="text" name="title" value="<%=book.getTitle()%>"><br>
    authorName: <input type="text" name="authorName" value="<%=book.getAuthorName()%>"><br>
    price: <input type="number" name="price" value="<%=book.getPrice()%>"><br>
    picture: <input type="file" name="picture"><br>
    <input type="submit" value="update book">
</form>
</body>
</html>