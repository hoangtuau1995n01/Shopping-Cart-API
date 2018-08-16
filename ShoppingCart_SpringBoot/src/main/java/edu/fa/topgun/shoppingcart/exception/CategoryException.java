package edu.fa.topgun.shoppingcart.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import edu.fa.topgun.shoppingcart.service.impl.CategoryServiceImp;

public class CategoryException extends RuntimeException {

  private static final Logger logger = LoggerFactory
      .getLogger(CategoryServiceImp.class);

  private static final long serialVersionUID = 1L;

  public CategoryException(String exception) {
    super(exception);
    logger.error(exception);
  }
}
