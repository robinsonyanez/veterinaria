package T3;

import java.util.List;
import java.util.Optional;

public interface IAtencionService {
    
    public List<Atencion> Listar();
    public Optional<Atencion> ConsultarId(int id);
    public void Guardar(Atencion p);
    public void Eliminar(int id);
    public List<Atencion> Buscar(String dato);
    public List<Atencion> OrdenarAsc();
    public List<Atencion> OrdenarDesc();
}
