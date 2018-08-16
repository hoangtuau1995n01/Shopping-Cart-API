/*
 * (C) Copyright 2018 TopGun. All Rights Reserved.
 *
 * @author ToanTQ6  
 * @date 2018/07/21
 * @name TestUtil.java
 * @version 1.0
 */

package edu.fa.topgun.shoppingcart.controllertest;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.MediaType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TestUtil {
  public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(
      MediaType.APPLICATION_JSON.getType(),
      MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

  /**
   * convertObjectToJsonBytes.
   * @param object Object
   * @return byte
   * @throws IOException IO Exception
   */
  public static byte[] convertObjectToJsonBytes(Object object)
      throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    return mapper.writeValueAsBytes(object);
  }
}
