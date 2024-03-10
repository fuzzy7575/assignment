package com.management.category.view;

import com.management.category.model.dto.CategoryDTO;
import com.management.product.model.dto.ProductDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CategoryPrint {

    public void printTeamList(List<CategoryDTO> categoryList, Map<String, String> parameter) {

        // 조회한 목록 출력하는 메소드
        // 전체 목록 조회인지, 순위별 제품분류 조회인지 구분하여 출력
        System.out.println(parameter);

        // List<CategoryDTO>로 받아온 데이터 목록을 전체 출력
        for(CategoryDTO category : categoryList) {
            System.out.println(category);
        }
    }

    public void printSuccessMessage(String successCode) {

        // 성공메시지를 출력하는 메소드

        String successMessage = "";
        switch (successCode) {
            case "selectCategoryList" : successMessage = "제품분류 목록 조회를 성공하였습니다."; break;
            case "registNewCategory" : successMessage = "제품분류 정보 등록을 성공하였습니다."; break;
            case "modifyCategoryName" : successMessage = "제품분류 정보 수정을 성공하였습니다."; break;
            case "deleteCategory" : successMessage = "제품분류 정보 삭제를 성공하였습니다."; break;
        }
        System.out.println(successMessage);

    }

    public void printErrorMessage(String errorCode) {

        // 에러메시지를 출력하는 메소드

        String errorMessage = "";
        switch (errorCode) {
            case "selectAllList" : errorMessage = "제품분류 목록 조회를 실패하였습니다."; break;
            case "registNewCategory" : errorMessage = "제품분류 정보 등록을 실패하였습니다."; break;
            case "modifyCategoryName" : errorMessage = "제품분류 정보 수정을 실패하였습니다."; break;
            case "deleteCategory" : errorMessage = "제품분류 정보 삭제를 실패하였습니다."; break;

        }
        System.out.println(errorMessage);

    }

}
