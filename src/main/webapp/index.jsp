<%@ page import="java.util.Calendar" %>
<%@ page import="java.util.GregorianCalendar" %><%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  </head>
  <body>
  <h1><% if (new GregorianCalendar().get(Calendar.HOUR_OF_DAY) < 12) {%>
      BEFORE 12 PM
    <% } else { %>
    AFTER 12 PM
    <% } %></h1>
  </body>
</html>
