package web;

import DB.ClienteDaoJDBC;
import entidad.Cliente;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ServletControlador")
public class ServletControlador extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        
        String accion = req.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "editar":
                    this.editarCliente(req, resp);
                    break;
                case "eliminar":
                        this.eliminarCliente(req, resp);
                        break;
                default:
                    this.accionDefault(req, resp);                   
            }
        }else{
           this.accionDefault(req, resp);
        }    
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String accion = req.getParameter("accion");
        if(accion != null){
            switch(accion){
                case "insertar":
                    this.insertarCliente(req, resp);
                    break;
                case "modificar":
                    this.modificarCliente(req, resp);
                    break;
            }
        }
    }
    
    private void eliminarCliente(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
    
        //recuperar el idCliente
        int idCliente = Integer.parseInt(req.getParameter("idCliente"));
        //creamos el objeeto cliente
        Cliente cliente = new Cliente(idCliente);
        //enviamos al dao
        int registroMod = new ClienteDaoJDBC().eliminarCliente(cliente);
        System.out.println("registroMod");
        this.accionDefault(req, resp);
    }
    
    private void modificarCliente (HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
      //recuperar los datos del cliente
      int idCliente = Integer.parseInt(req.getParameter("idCliente"));
      String nombre = req.getParameter("nombre");
      String apellido = req.getParameter("apellido");
      String email = req.getParameter("email");
      String telefono = req.getParameter("telefono");    
      double saldo = 0;
        String saldoString = req.getParameter("saldo");
        if(saldoString != null && !"".equals(saldoString)){
           saldo = Double.parseDouble(saldoString);
        }
        
        //creamos el objeto
        Cliente cliente = new Cliente(idCliente, nombre, apellido, email, telefono, saldo);
        
        int registrosMod = new ClienteDaoJDBC().actualizarCliente(cliente);
        System.out.println("CANTIDAD DE REGISTROS MODIFICADOS: "+registrosMod);
        
        //redirigir al inico
        this.accionDefault(req, resp);
    }    
        
        

    
    private void editarCliente(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
       // recuperar el id del cliente
       int idCliente = Integer.parseInt(req.getParameter("idCliente"));
       Cliente clienteEnv = new Cliente(idCliente);
       ClienteDaoJDBC jd = new ClienteDaoJDBC();
       Cliente cliente = jd.encontrarClienteById(clienteEnv);
       req.setAttribute("cliente", cliente);
       String jspEditar = "WEB-INF/cliente/editarCliente.jsp";
       req.getRequestDispatcher(jspEditar).forward(req, resp);
       
    }
    
    
    
    private void insertarCliente(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        String nombre =req.getParameter("nombre");
        String apellido =req.getParameter("apellido");
        String email =req.getParameter("email");
        String telefono =req.getParameter("telefono");
        double saldo = 0;
        String saldoString = req.getParameter("saldo");
        if(saldoString != null && !"".equals(saldoString)){
           saldo = Double.parseDouble(saldoString);
        }
        //crear el objeto cliente
        Cliente cliente = new Cliente(nombre, apellido, email, telefono, saldo);
    
        //insertar el cliente
        int registroMod = new ClienteDaoJDBC().insertarCliente(cliente);
        System.out.println(registroMod);
        
        this.accionDefault(req, resp);
    }
    
    private void accionDefault(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        List<Cliente> clientes = new ClienteDaoJDBC().ListarClientes();
        
        HttpSession sesion = req.getSession();
        sesion.setAttribute("clientes", clientes);
        sesion.setAttribute("totalClientes", clientes.size());
        sesion.setAttribute("saldoTotal", calcularSaldoTotal(clientes));
        
        
        
        resp.sendRedirect("clientes.jsp");
    }
    private double calcularSaldoTotal(List<Cliente> clientes){
        double saldoTotal = 0;
        for (Cliente cliente : clientes){
            saldoTotal += cliente.getSaldo();
        }
        return saldoTotal;
    }  
}
