<%@page import="com.emergentes.Registro"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <title>Mostrar Registros</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        function editarRegistro(id) {
            $.get("EditarRegistro?id=" + id, function(data) {
                window.location.href = "EditarRegistro.jsp";
            });
        }

        function eliminarRegistro(id) {
            $.get("EliminarRegistro?id=" + id, function(data) {
                location.reload();
            });
        }
    </script>
</head>
<body>
    <h2>Registros</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellidos/th>
            <th>Seminario</th>
            <th>Confirmado</th>
            <th>Fecha_Inscripcion</th>
            <th>Editar</th>
            <th>Eliminar</th>
        </tr>
        <c:forEach var="registro" items="${registros}">
            <tr>
                <td>${registro.id}</td>
                <td>${registro.nombre}</td>
                <td>${registro.apellidos}</td>
                <td>${registro.seminarios}</td>
                <td>${registro.confimrmado}</td>
                <td>${registro.fehcha_Inscripcion}</td>
                <td><button onclick="editarRegistro(${registro.id})">Editar</button></td>
                <td><button onclick="eliminarRegistro(${registro.id})">Eliminar</button></td>
            </tr>
        </c:forEach>
    </table>
    <br>
    <a href="formulario.jsp">Nuevo Registro</a>
    </body>
</html>
