
 <%@ page import="user.User" %>
<%@ page import="java.sql.Blob" %>
<%@ page import="java.sql.Clob" %>
<%@ page import="java.io.Reader" %>

<table class="table">
  <tr>
    <td data-th="registration"><%User user=(User)request.getAttribute("registration");
    out.print(user.getFirstName()+" ");
    out.print(user.getEmail()+" ");
    out.print(user.getCity()+" ");
    %></td>
  </tr>
</table>

