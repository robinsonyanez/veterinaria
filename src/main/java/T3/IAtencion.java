package T3;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAtencion extends CrudRepository<Atencion,Integer>{
    
    //Aqui podría crear otros métodos específicos
    //Consultas SQL, Procedures
    
    @Query(value="SELECT * FROM atencion "
            + "WHERE mascota LIKE %?1% "
            + "OR servicio LIKE %?1% "
            + "OR costo LIKE %?1%",nativeQuery=true)
    List<Atencion> bucarPorTodo(String dato);
    
    @Query(value="SELECT * FROM atencion "
            + "ORDER BY mascota ASC",nativeQuery=true)
    List<Atencion> OrdenAscendente();
    
    @Query(value="SELECT * FROM atencion "
            + "ORDER BY mascota DESC",nativeQuery=true)
    List<Atencion> OrdenDescendente();
}
