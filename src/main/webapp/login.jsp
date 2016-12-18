
<%@ page import="user.User" %>
<%@ page import="java.sql.Blob" %>
<%@ page import="java.sql.Clob" %>
<%@ page import="java.io.Reader" %>

<table class="rwd-table">
  <tr>
    <th>Name</th>
    <th>City</th>
    <th>Description</th>
    <th>Image</th>
  </tr>
  <tr>
    <td data-th="Movie Title"><%User user=(User)request.getAttribute("user");
    out.print(user.getFirstName());
    out.print(user.getSity());
    Clob desc=user.getDesciption();
    Reader reader=desc.getCharacterStream(); 
    char [] buffer=new char[(int)desc.length()];
    reader.read(buffer);
   	for(char thechar:buffer){
   		out.print(thechar);
   	}
    %></td>
  </tr>
  <tr>
    <td data-th="Movie Title">Howard The Duck</td>
    <td data-th="Genre">"Comedy"</td>
    <td data-th="Year">1986</td>
    <td data-th="Gross">$16,295,774</td>
  </tr>
  <tr>
    <td data-th="Movie Title">American Graffiti</td>
    <td data-th="Genre">Comedy, Drama</td>
    <td data-th="Year">1973</td>
    <td data-th="Gross">$115,000,000</td>
  </tr>
</table>
