package com.management.product.controller;

import com.common.SearchCondition;
import com.management.product.model.dto.ProductDTO;
import com.management.product.model.service.ProductService;
import com.management.product.view.ProductPrint;

import java.util.List;
import java.util.Map;

public class ProductController {

    // Service와 Print 객체 선언

    private final ProductService productService;
    private final ProductPrint productPrint;
    public ProductController() {
        productService = new ProductService();
        productPrint = new ProductPrint();
    }

    public void selectAllProductList() {

        // 전체 제품 목록을 조회하는 메소드

        List<ProductDTO> productList = productService.selectAllProductList();

        if(productList != null) {
            productPrint.printAllProductList(productList);
        } else {
            productPrint.printErrorMessage("selectAllList");
        }

    }

    public void selectProductByCondition(SearchCondition searchCondition) {

        // 조건에 따른 제품 목록을 조회하는 메소드
        // List<ProductDTO> 타입으로 조건에 따른 제품 목록을 조회
        // 조회 조건과 제품 목록을 출력

        List<ProductDTO> productList = productService.selectProductByCondition(searchCondition);

        if(productList != null && productList.size() > 0) {
                productPrint.printProductList(productList, searchCondition);
//                productPrint.printSuccessMessage("searchCondition");
            } else {
                productPrint.printErrorMessage("searchCondition");
            }
        }

    public void registNewProduct(ProductDTO product) {

        // 제품 정보를 등록하는 메소드
        // 결과를 boolean 값으로 return

        boolean result = productService.registNewProduct(product);

        if(result) {
            productPrint.printSuccessMessage("registNewProduct");
        } else {
            productPrint.printErrorMessage("registNewProduct");
        }

    }

    public void modifyProductInfo(ProductDTO product) {

        // 제품 정보를 수정하는 메소드
        // 결과를 boolean 값으로 return

        boolean result = productService.modifyProductInfo(product);

        if(result) {
            productPrint.printSuccessMessage("modifyProductInfo");
        } else {
            productPrint.printErrorMessage("modifyProductInfo");
        }

    }

    public void deleteProduct(Map<String, String> parameter) {

        // 제품 정보를 삭제하는 메소드
        // 결과를 boolean 값으로 return

        boolean result = productService.deleteProduct(parameter);

        if(result) {
            productPrint.printSuccessMessage("deleteProduct");
        } else {
            productPrint.printErrorMessage("deleteProduct");
        }

    }
}
