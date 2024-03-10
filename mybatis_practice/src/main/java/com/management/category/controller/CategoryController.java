package com.management.category.controller;

import com.common.SearchCondition;
import com.management.category.model.dto.CategoryDTO;
import com.management.category.model.service.CategoryService;
import com.management.category.view.CategoryPrint;

import java.util.List;
import java.util.Map;

public class CategoryController {

    //  Service와 Print 객체를 선언
    private final CategoryService categoryService;
    private final CategoryPrint categoryPrint;
    public CategoryController() {
        categoryService = new CategoryService();
        categoryPrint = new CategoryPrint();
    }

    public void selectCategoryList(Map<String, String> parameter) {

        // 제품분류 목록을 조회하는 메소드
        // List<CategoryDTO> 타입으로 제품분류 목록을 조회

        List<CategoryDTO> categoryList = categoryService.selectCategoryList(parameter);

        if(categoryList != null) {
            categoryPrint.printTeamList(categoryList, parameter);
//            categoryPrint.printSuccessMessage("selectCategoryList");
        } else {
            categoryPrint.printErrorMessage("selectCategoryList");
        }

    }

    public void registNewCategory(CategoryDTO category) {

        // 제품분류 정보를 등록하는 메소드
        // 결과를 boolean 값으로 return

        Boolean result = categoryService.registNewCategory(category);

        if(result) {
            categoryPrint.printSuccessMessage("registNewCategory");
        } else {
            categoryPrint.printErrorMessage("registNewCategory");
        }

    }

    public void modifyCategoryName(CategoryDTO category) {

        // 제품분류 정보를 수정하는 메소드
        // 결과를 boolean 값으로 return

        Boolean result = categoryService.modifyCategoryName(category);

        if(result) {
            categoryPrint.printSuccessMessage("modifyCategoryName");
        } else {
            categoryPrint.printErrorMessage("modifyCategoryName");
        }

    }

    public void deleteCategory(Map<String, String> parameter) {

        // 제품분류 정보를 삭제하는 메소드
        // 결과를 boolean 값으로 return

        Boolean result = categoryService.deleteCategory(parameter);

        if(result) {
            categoryPrint.printSuccessMessage("deleteCategory");
        } else {
            categoryPrint.printErrorMessage("deleteCategory");
        }

    }
}
