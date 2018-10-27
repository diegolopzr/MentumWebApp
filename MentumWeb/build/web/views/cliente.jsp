<script language="javascript">
    function irAmenu(){
       document.location.href= "../index.jsp";
    }

</script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CLIENTE</title>
        <link rel="stylesheet" href="views/css/estilo.css">
    </head>
    <body>
        <header>
        <nav class="navegacion">
            <h1>Crear Cliente</h1>
            <form action="../controladorCliente" method="post">
                <strong>Datos del cliente</strong><br/> <br/>
                <label for="nombre" size="20">Nombre: </label>
                <input type="text" name="nombre_Cliente" size="10" />
                <br/> <br/>
                <label for="nombre" size="15">Direccion: </label>
                <input type="text" name="direccion_Cliente" size="10" />
                <br/> <br/>
                <label for="nombre" size="15">Telefono: </label>
                <input type="text" name="telefono_Cliente"  size="10" />
                <br/> <br/>
                <label for="nombre" size="15">Fecha creacion: </label>
                <input type="date" name="fecha_Cliente" size="10" />
                <br/> <br/>
                <input type="submit" value="Agregar" name="agregar_Cliente" />
                <input type="reset"  value="Restablecer" /> 
                <input type="button"  value="::: MENU :::"  onclick= "irAmenu()"/>
            </form>
        </nav>
        </header>
    </body>
</html>
