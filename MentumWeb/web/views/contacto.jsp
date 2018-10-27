<%@page import="java.util.ArrayList"%>
<script language="javascript">
    function irAmenu(){
       document.location.href= "../index.jsp";
    }

</script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CONTACTO</title>
        <link rel="stylesheet" href="views/css/estilo.css">
    </head>
    <body>
        <h1>Crear Contacto</h1>
        <form action="../controladorContacto" method="post">
            <strong>Datos del contacto</strong><br/> <br/>
            <label for="nombre" size="20">Nombre: </label>
            <input type="text" name="nombre_Contacto" value="" size="10" />
            <br/> <br/>
            <label for="nombre" size="15">Direccion: </label>
            <input type="text" name="direccion_Contacto" value="" size="10" />
            <br/> <br/>
            <label for="nombre" size="15">Telefono: </label>
            <input type="text" name="telefono_Contacto" value="" size="10" />
            <br/> <br/>            

            <label for="nombre" size="15">Nombre del cliente: </label>
            <jsp:useBean id="cn" class="datos.ClienteDAO" scope="page"></jsp:useBean>
            <%
                ArrayList<String> _lista = cn.nombresClientes();
            %>
            <select name="nom_clientescontacto">
                <option selected value="0">Seleccione:</option>
                <%
                    for (String nCliente : _lista) {
                %>
                <option value="<%= nCliente%>"><%= nCliente  %></option>
                <%
                    }

                %>
            </select>
            <br/> <br/>
            <input type="submit" value="Agregar" name="agregar_Contacto" />
            <input type="reset"  value="Restablecer" /> 
            <input type="button"  value="::: MENU :::"  onclick= "irAmenu()"/>
        </form>
    </body>
</html>
