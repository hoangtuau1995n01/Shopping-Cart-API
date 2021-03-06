package edu.fa.topgun.shoppingcart.controller;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import edu.fa.topgun.shoppingcart.exception.CategoryException;
import edu.fa.topgun.shoppingcart.exception.ErrorDetails;
import edu.fa.topgun.shoppingcart.exception.OrderDetailException;
import edu.fa.topgun.shoppingcart.exception.OrderException;
import edu.fa.topgun.shoppingcart.exception.ProductException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler
    extends ResponseEntityExceptionHandler {

  /**
   * handleAllExceptions.
   * 
   * @param ex
   * 
   * @param request
   * 
   * @return
   */
  @ExceptionHandler(Exception.class)
  public final ResponseEntity<Object> handleAllExceptions(Exception ex,
      WebRequest request) {
    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
        request.getDescription(false));
    return ResponseEntity.badRequest().body(errorDetails);
  }

  /**
   * Handle product exception.
   * 
   * @param ex      the ProductException
   * 
   * @param request the request
   * 
   * @return
   */
  @ExceptionHandler(ProductException.class)
  public final ResponseEntity<Object> handleProductException(
      ProductException ex, WebRequest request) {
    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
        request.getDescription(false));
    return ResponseEntity.badRequest().body(errorDetails);
  }

  /**
   * Handle category exception.
   * 
   * @param ex      the ProductException
   * 
   * @param request the request
   * 
   * @return
   */
  @ExceptionHandler(CategoryException.class)
  public final ResponseEntity<Object> handleCategoryException(
      CategoryException ex, WebRequest request) {
    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
        request.getDescription(false));
    return ResponseEntity.badRequest().body(errorDetails);
  }

  /**
   * Handle order exception.
   * 
   * @param ex      the ProductException
   * 
   * @param request the request
   * 
   * @return
   */
  @ExceptionHandler(OrderException.class)
  public final ResponseEntity<Object> handleOrderException(OrderException ex,
      WebRequest request) {
    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
        request.getDescription(false));
    return ResponseEntity.badRequest().body(errorDetails);
  }

  /**
   * Handle product exception.
   * 
   * @param ex      the ProductException
   * 
   * @param request the request
   * 
   * @return
   */
  @ExceptionHandler(OrderDetailException.class)
  public final ResponseEntity<Object> handleOrderDetailException(
      OrderDetailException ex, WebRequest request) {
    ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),
        request.getDescription(false));
    return ResponseEntity.badRequest().body(errorDetails);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(
      MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    ErrorDetails errorDetails = new ErrorDetails(new Date(),
        ex.getBindingResult().getAllErrors().get(0).getDefaultMessage()
            .toString(),
        ex.getBindingResult().toString());
    return ResponseEntity.badRequest().body(errorDetails);
  }
}