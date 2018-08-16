package edu.fa.topgun.shoppingcart.service;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.fa.topgun.shoppingcart.dto.CategoryDto;
import edu.fa.topgun.shoppingcart.repository.CategoryRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

  @Autowired
  private CategoryService cateService;

  @Autowired
  private CategoryRepository cateRepo;

  private CategoryDto dto;

  @Before
  public void setUp() {
    dto = mockCategoryDto();
  }

//  @After
//  public void tearDown() {
//    cateRepo.deleteAll();
//    ;
//  }

  @Test
  public void createCategoryTest() {
    cateService.createCategory(dto);
    List<CategoryDto> dtos = cateService.listCategory();
    CategoryDto dtoActual = dtos.get(0);
    assertDto(dto,dtoActual);
  }
  
  
  @Test
  public void getAllCategoryTest() {
    cateService.createCategory(dto);
    List<CategoryDto> dtos = cateService.listCategory();
    CategoryDto dtoActual = dtos.get(0);
    assertDto(dto,dtoActual);
  }
  
  private CategoryDto mockCategoryDto() {
    CategoryDto cateDto = new CategoryDto();
    cateDto.setName("Microsoft");
    cateDto.setDescription("Microsoft");
    cateDto.setIdcategory(2);
    return cateDto;
  }
  
  private void assertDto(CategoryDto dtoExpect,CategoryDto dtoActually) {
    Assert.assertEquals(dtoExpect.getName(), dtoActually.getName());
    Assert.assertEquals(dtoExpect.getDescription(), dtoActually.getDescription()); 
  }
  
  @Test
  public void findByCategoryIdTest() {
    cateService.findByCategoryId(2);
    
  }
  
}
