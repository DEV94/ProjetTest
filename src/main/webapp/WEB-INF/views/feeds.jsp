<%@ page import="java.util.ArrayList" %>
<%@ page import="com.polytech.business.Post" %><%--
  Created by IntelliJ IDEA.
  User: dev
  Date: 3/15/17
  Time: 9:36 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<table class="table table-hover">
    <thead>
    <tr>
        <th>Postes</th>
    </tr>
    </thead>
    <tbody>
    <%
        ArrayList<Post> list = (ArrayList<Post>)request.getAttribute("posts");
        for (Post p: list) {
    %>
    <tr>
        <td>
            <%
                p.toString();
            %>
        </td>
    </tr>
    <%
        }
    %>

    </tbody>
</table>

</body>
</html>
