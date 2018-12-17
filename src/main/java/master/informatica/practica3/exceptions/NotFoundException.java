package master.informatica.practica3.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * NotFoundException
 */
@ResponseStatus(code= HttpStatus.NOT_FOUND, reason="data not found")
public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = -1299910235329169264L;
}