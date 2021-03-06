package fincaV1.server.exception;

import javax.persistence.NoResultException;
import javax.validation.ValidationException;

import org.aspectj.weaver.ast.Test;
import org.hibernate.PropertyValueException;
import org.hibernate.engine.internal.Nullability;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.util.NestedServletException;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import fincaV1.server.entity.ResponseBean;
import fincaV1.server.helper.Helper;


@ControllerAdvice
public class ExceptionsHandle {
	@Autowired
	Helper helper;
	
	public ResponseBean responseBean;
	
    @ExceptionHandler
	public ResponseEntity<ResponseBean> numberFormatException(NumberFormatException exc) {
    	ResponseBean oBean = new ResponseBean(400, "Error");
    	return new ResponseEntity<ResponseBean>(oBean, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler
    public ResponseEntity<ResponseBean> notLogginSesionException(NotLogginSesionException exc){
    	responseBean = new ResponseBean(401, exc.getMessage());
    	return new ResponseEntity<ResponseBean>(responseBean, HttpStatus.UNAUTHORIZED);
    }
    
    //Aqui recojo las excepciones que ocurren con la anotacion @NotNull de hibernate
    @ExceptionHandler
    public ResponseEntity<ResponseBean> notNull(PropertyValueException exc){
    	responseBean = new ResponseBean(500, exc.getMessage());
    	return new ResponseEntity<ResponseBean>(responseBean, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @ExceptionHandler
    public ResponseEntity<ResponseBean> notExistForeignKey(NotExistForeignKey exc){
    	responseBean = new ResponseBean(500, exc.getMessage());
    	return new ResponseEntity<ResponseBean>(responseBean, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    //El formato del Bean no es el correcto
    @ExceptionHandler
    public ResponseEntity<ResponseBean> badBeanFormat(BadBeanFormat exc){
    	responseBean = new ResponseBean(500, exc.getMessage());
    	return new ResponseEntity<ResponseBean>(responseBean, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    //Formato de json a pojo incorrecto
    @ExceptionHandler
    public ResponseEntity<ResponseBean> badJaksonFormat(InvalidFormatException exc){
    	responseBean = new ResponseBean(500, "Error conviertiendo json a " + exc.getTargetType() + " ,valor: " + exc.getValue() );
    	return new ResponseEntity<ResponseBean>(responseBean, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
