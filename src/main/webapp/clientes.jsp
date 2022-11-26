
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
        <title>control clientes</title>
    </head>
    <body>
        <!--cabecero-->
        <jsp:include page="/WEB-INF/comunes/cabecero.jsp"/>
        
        <!-- botones de navegacion -->
        <jsp:include page="/WEB-INF/comunes/botonesNavegacion.jsp"/>
        
       <!-- modal para agregar clientes-->
        <jsp:include page="/WEB-INF/cliente/agregarCliente.jsp"/>
        
        <!-- liistado de clientes -->
        <jsp:include page="WEB-INF/cliente/listadoClientes.jsp"/>
   
         <!-- pie de pagina -->
        <jsp:include page="WEB-INF/comunes/footer.jsp"/>      
   
        <!--script-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.min.js" integrity="sha384-IDwe1+LCz02ROU9k972gdyvl+AESN10+x7tBKgc9I5HFtuNz0wWnPclzo6p9vxnk" crossorigin="anonymous"></script>

        
    </body>
</html>
