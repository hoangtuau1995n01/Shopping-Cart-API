package edu.fa.topgun.shoppingcart.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.fa.topgun.shoppingcart.service.impl.ProductServiceImp;

public class ProductException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  private static final Logger logger = LoggerFactory
      .getLogger(ProductServiceImp.class);

  public ProductException(String exception) {
    super(exception);
    logger.error(exception);
  }
}
