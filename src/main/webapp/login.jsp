
<%@ page import="user.User" %>
<%@ page import="java.sql.Blob" %>
<%@ page import="java.sql.Clob" %>
<%@ page import="java.io.Reader" %>

<table class="table">
  <tr>
    <td data-th="login"><%User user=(User)request.getAttribute("login");
    out.print(user.getFirstName()+" ");
    out.print(user.getCity()+" ");
    out.print(user.getEmail()+" ");
    
    %></td>
  </tr>
</table>
