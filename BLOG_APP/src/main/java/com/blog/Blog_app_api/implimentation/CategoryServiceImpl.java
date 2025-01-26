package com.blog.Blog_app_api.implimentation;

import com.blog.Blog_app_api.dto.CategoryDto;
import com.blog.Blog_app_api.dto.UserDto;
import com.blog.Blog_app_api.entity.Category;
import com.blog.Blog_app_api.exception.ResourceNotFoundException;
import com.blog.Blog_app_api.repositories.CategoryRepository;
import com.blog.Blog_app_api.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CategoryServiceImpl implements CategoryService {
   @Autowired
    private  CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category=this.categoryDtoToCategory(categoryDto);
        Category saveCategory=this.categoryRepository.save(category);
        return  this.CategoryToCategoryDto(saveCategory);

    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto , Integer categoryId) {
         Category category=this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categoryId));

//         category.setCategoryId(categoryDto.getCategoryId());
         category.setCategoryTitle(categoryDto.getCategoryTitle());
         category.setGetCategoryDescription(categoryDto.getCategoryDescription());

         Category updatedCategory=this.categoryRepository.save(category);


         return this.CategoryToCategoryDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category category=this.categoryRepository.findById(categoryId).orElseThrow(()->
                new ResourceNotFoundException("Category","categoryId",categoryId));
        this.categoryRepository.delete(category);
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category category=this.categoryRepository.findById(categoryId).orElseThrow(()->
                new ResourceNotFoundException("Category","categoryId",categoryId));
       return this.CategoryToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
        List<Category> categoryList=this.categoryRepository.findAll();

        return categoryList.stream().map(this::CategoryToCategoryDto).collect(Collectors.toList());
    }

    public CategoryDto CategoryToCategoryDto(Category category){
        CategoryDto categoryDto=new CategoryDto();
        categoryDto.setCategoryId(category.getCategoryId());
        categoryDto.setCategoryTitle(category.getCategoryTitle());
        categoryDto.setCategoryDescription(category.getGetCategoryDescription());
        return categoryDto;
    }
    public Category categoryDtoToCategory(CategoryDto categoryDto){
        Category category=new Category();
        category.setCategoryId(categoryDto.getCategoryId());
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setGetCategoryDescription(categoryDto.getCategoryDescription());
        return  category;
    }
}
