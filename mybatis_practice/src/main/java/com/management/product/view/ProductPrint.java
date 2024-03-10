package com.management.product.view;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;

import java.util.List;

public class ProductPrint {

    public void printAllProductList(List<ProductDTO> allProductList) {

        // 전체 조회한 목록 출력하는 메소드
        for(ProductDTO product : allProductList) {
            System.out.println(product);
        }

    }

    public void printProductList(List<ProductDTO> productList, SearchCondition searchCondition) {

        // 조건에 따라 조회한 목록을 출력하는 메소드
        // 검색 조건이 무엇인지 출력
        System.out.println(searchCondition);

        // List<ProductDTO>로 받아온 데이터 목록 전체 출력
        for(ProductDTO product : productList) {
            System.out.println(product);
        }
    }

    public void printSuccessMessage(String successCode) {

        // 성공메시지를 출력하는 메소드

        String successMessage = "";
        switch (successCode) {
            case "selectAllList" : successMessage = "제품 목록 조회를 성공하였습니다."; break;
            case "searchCondition" : successMessage = "조건에 따른 제품 목록 조회를 성공하였습니다."; break;
            case "registNewProduct" : successMessage = "제품 등록을 성공하였습니다."; break;
            case "modifyProductInfo" : successMessage = "제품 수정을 성공하였습니다."; break;
            case "deleteProduct" : successMessage = "제품 삭제를 성공하였습니다."; break;
        }
        System.out.println(successMessage);


    }

    public void printErrorMessage(String errorCode) {

        // 에러메시지를 출력하는 메소드

        String errorMessage = "";
        switch (errorCode) {
            case "selectAllList" : errorMessage = "제품 목록 조회를 실패하였습니다."; break;
            case "searchCondition" : errorMessage = "조건에 따른 제품 목록 조회를 실패하였습니다."; break;
            case "registNewProduct" : errorMessage = "제품 등록을 실패하였습니다."; break;
            case "modifyProductInfo" : errorMessage = "제품 수정을 실패하였습니다."; break;
            case "deleteProduct" : errorMessage = "제품 삭제를 실패하였습니다."; break;
        }
        System.out.println(errorMessage);


    }

}
