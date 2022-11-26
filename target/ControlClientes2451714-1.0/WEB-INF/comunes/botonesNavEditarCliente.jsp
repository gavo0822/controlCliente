<section id="actions" class="py-4 mb-4 bg-light">
    <div class="container col-8 align-items-center">
        <div class="row justify-content-md-center">
                
            <div class="col-md-3">
                <a class="btn btn-secondary btn-block" href="index.html">
                    <i class="bi bi-arrow-return-left"></i>Regresar al inicio 
                </a> 
            </div>
            <div class="col-md-3">
                <button type="submit" class="btn btn-primary btn-block">
                  <i class="bi bi-check-circle"></i> Actualizar   
                </button>
            </div>
            <div class="col-md-3">
                <a href ="ServletControlador?accion=eliminar&idCliente=${cliente.idCliente}"
                   class="btn btn-danger btn-block">
                    <i class="bi bi-trash"></i>Eliminar 
                </a> 
            </div>             
        </div>
    </div>
</section>