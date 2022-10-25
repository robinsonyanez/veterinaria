package T3;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {
    
    @Autowired
    private IAtencionService service;
    
    @GetMapping("/")
    public String Mostrar(Model model)
    {
       List<Atencion> atenciones =  service.Listar();
       model.addAttribute("atenciones", atenciones);
       
       return "lista"; //lista.html
    }
    
    @GetMapping("/eliminar")
    public String Eliminar(@RequestParam("id") int id, Model model)
    {
        service.Eliminar(id);
        
        return Mostrar(model);
    }
    
    //Si es que tu formulario no es un modal
    @GetMapping("/nuevo")
    public String Nuevo()
    {
        return "nuevo"; //nuevo.html
    }

    @PostMapping("/registrar")
    public String Registrar(@RequestParam("masc") String masc,
                            @RequestParam("serv") String serv,
                            @RequestParam("cost") float cost,
                            Model model)
    {
        Atencion a = new Atencion();
        a.setMascota(masc);
        a.setServicio(serv);
        a.setCosto(cost);
        
        service.Guardar(a);
        
        return Mostrar(model);
    }
    
    
    @PostMapping("/actualizar")
    public String Actualizar(@RequestParam("id") int id,
                            @RequestParam("masc") String masc,
                            @RequestParam("serv") String serv,
                            @RequestParam("cost") float cost,
                            Model model)
    {

        Atencion a = new Atencion();
        a.setId(id);
        a.setMascota(masc);
        a.setServicio(serv);
        a.setCosto(cost);
        
        service.Guardar(a); //En este caso actualiza porque envias el ID
        
        return Mostrar(model);
    }
    
    @PostMapping("/buscar")
    public String Buscar(@RequestParam("dato") String dato, Model model)
    {
        List<Atencion> atenciones = service.Buscar(dato);
        model.addAttribute("atenciones", atenciones);
        
        return "lista"; //lista.html
    }
    
    @GetMapping("/orden_asc")
    public String OrdenarAscendente(Model model)
    {
        List<Atencion> atenciones = service.OrdenarAsc();
        model.addAttribute("atenciones", atenciones);
        
        return "lista"; //lista.html
    }
    
    @GetMapping("/orden_desc")
    public String OrdenarDescendente(Model model)
    {
        List<Atencion> atenciones = service.OrdenarDesc();
        model.addAttribute("atenciones", atenciones);
        
        return "lista"; //lista.html
    }
    
}
