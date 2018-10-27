<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mensaje</title>
    </head>
    <body>
        <h1><center>
                <%= (request.getParameter("mensaje")!= null)
                        ?request.getParameter("mensaje"):"Error desconocido" %>
                <br/><a href="../index.jsp">Regresar</a>
            </center
        </h1>

    </body>
</html>

