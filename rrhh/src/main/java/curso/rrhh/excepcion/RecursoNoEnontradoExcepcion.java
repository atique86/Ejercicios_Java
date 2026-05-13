package curso.rrhh.excepcion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecursoNoEnontradoExcepcion extends RuntimeException{
    public RecursoNoEnontradoExcepcion(String mensaje){
        super(mensaje);
    }
}