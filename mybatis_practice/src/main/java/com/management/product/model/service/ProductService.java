package com.management.product.model.service;

import com.common.SearchCondition;
import com.management.product.model.dao.ProductDAO;
import com.management.product.model.dto.ProductDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlSession;

public class ProductService {
    private ProductDAO mapper;   //DAO 객체 선언

    public List<ProductDTO> selectAllProductList() {

        // 전체 제품 목록을 조회하는 로직

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ProductDAO.class);

        List<ProductDTO> productList = mapper.selectAllProductList();

        sqlSession.close();
        return productList;

    }

    public List<ProductDTO> selectProductByCondition(SearchCondition searchCondition) {

        // 조건에 따른 제품 목록을 조회하는 로직

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ProductDAO.class);

        List<ProductDTO> productList = mapper.selectProductByCondition(searchCondition);

        sqlSession.close();
        return productList;

    }

    public boolean registNewProduct(ProductDTO product) {

        // 제품 정보를 등록하는 로직

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ProductDAO.class);

        boolean result =  mapper.insertProduct(product);

        if(result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;

    }

    public boolean modifyProductInfo(ProductDTO product) {

        // 제품 정보를 수정하는 로직을 작성하세요.

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ProductDAO.class);

        boolean result =  mapper.updateProduct(product);

        if(result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;

    }

    public boolean deleteProduct(Map<String, String> parameter) {

        // 제품 정보를 삭제하는 로직

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(ProductDAO.class);

        boolean result =  mapper.deleteProduct(parameter);

        if(result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;

    }
}
