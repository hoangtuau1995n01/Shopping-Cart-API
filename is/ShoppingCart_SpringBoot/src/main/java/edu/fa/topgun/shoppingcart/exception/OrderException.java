package edu.fa.topgun.shoppingcart.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.fa.topgun.shoppingcart.service.impl.OrderServiceImp;

public class OrderException extends RuntimeException {
  private static final Logger logger = LoggerFactory
      .getLogger(OrderServiceImp.class);

  private static final long serialVersionUID = 1L;

  public OrderException(String exception) {
    super(exception);
    logger.error(exception);
  }
}
