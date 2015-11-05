<%--
  Created by IntelliJ IDEA.
  User: jgoodson2
  Date: 11/4/15
  Time: 2:08 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>List Products</title>
</head>

<body>
${allProducts.name} ${allProducts.price} ${allProducts.sku}
<table border="1">
    <g:each in="${allProducts}" var="thisProduct">
        <tr>
            <td>${thisProduct.name}</td>
            <td>${thisProduct.price}</td>
            <td>${thisProduct.sku}</td>
        </tr>
    </g:each>
</table>
</body>
</html>