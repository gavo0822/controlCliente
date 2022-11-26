
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">        
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
        <title>Editar cliente</title>
    </head>
    <body>
        <jsp:include page="/WEB-INF/comunes/cabecero.jsp"/>

        <form action="ServletControlador?accion=modificar&idCliente=${cliente.idCliente}" method="post" class="was-validated">
            <section id="details">
                <div class="container">
                    <div class="row justify-content-md-center">
                        <div class="col-8">
                            <div class="card mt-3">
                                <div class="card-header">
                                    <h4>EDITAR CLIENTE</h4>            
                                </div>
                                <div class="card-body">
                                    <div class="form-group">
                                        <label for="nombre">Nombre</label>
                                        <input type="text" class="form-control" name="nombre" required value="${cliente.nombre}">
                                    </div>
                                    <div class="form-group">
                                        <label for="apellido">Apellido</label>
                                        <input type="text" class="form-control" name="apellido" required value="${cliente.apellido}">
                                    </div>
                                    <div class="form-group">
                                        <label for="email">Email</label>
                                        <input type="text" class="form-control" name="email" required value="${cliente.email}">
                                    </div>
                                    <div class="form-group">
                                        <label for="telefono">Telefono</label>
                                        <input type="number" class="form-control" name="telefono" required value="${cliente.telefono}">
                                    </div>
                                    <div class="form-group">
                                        <label for="saldo">Saldo</label>
                                        <input type="number" class="form-control" name="saldo" value="${cliente.saldo}">
                                    </div>      
                                </div>    
                            </div>
                        </div>
                    </div>
                </div>
            </section>  
              <!--botones de navegacion para editar cliente-->
             <jsp:include  page="/WEB-INF/comunes/botonesNavEditarCliente.jsp"/>
        </form>

        <jsp:include page="/WEB-INF/comunes/footer.jsp"/>
    </div>
</body>
</html>
