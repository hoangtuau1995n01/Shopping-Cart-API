package edu.fa.topgun.shoppingcart.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.fa.topgun.shoppingcart.service.impl.OrderDetailServiceImp;

public class OrderDetailException extends RuntimeException {
  private static final Logger logger = LoggerFactory
      .getLogger(OrderDetailServiceImp.class);

  private static final long serialVersionUID = 1L;

  public OrderDetailException(String exception) {
    super(exception);
    logger.error(exception);
  }
}
