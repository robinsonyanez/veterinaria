package T3;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtencionService implements IAtencionService  {

    @Autowired
    private IAtencion data;
    
    @Override
    public List<Atencion> Listar() {
        return (List<Atencion>) data.findAll(); //Select * from producto
    }

    @Override
    public Optional<Atencion> ConsultarId(int id) {
        return data.findById(id); //Select * from producto where id=id
    }

    @Override
    public void Guardar(Atencion p) {
        data.save(p);
    }

    @Override
    public void Eliminar(int id) {
        data.deleteById(id); //Delete from producto where id=id
    }

    @Override
    public List<Atencion> Buscar(String dato) {
        return data.bucarPorTodo(dato);
    }

    @Override
    public List<Atencion> OrdenarAsc() {
        return data.OrdenAscendente();
    }

    @Override
    public List<Atencion> OrdenarDesc() {
        return data.OrdenDescendente();
    }

}
