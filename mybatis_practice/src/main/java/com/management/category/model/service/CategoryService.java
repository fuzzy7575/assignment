package com.management.category.model.service;

import com.management.category.model.dao.CategoryDAO;
import com.management.category.model.dto.CategoryDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

import static com.common.Template.getSqlSession;

public class CategoryService {

    // DAO 객체를 선언
    private CategoryDAO mapper;

    public List<CategoryDTO> selectCategoryList(Map<String, String> parameter) {

        // 제품분류 목록을 조회하는 로직
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(CategoryDAO.class);

        List<CategoryDTO> categoryList = mapper.selectCategoryList(parameter);

        sqlSession.close();
        return categoryList;
    }

    public boolean registNewCategory(CategoryDTO category) {

        // 제품분류 정보를 등록하는 로직

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(CategoryDAO.class);

        boolean result = mapper.insertCategory(category);

        if(result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;

    }

    public boolean modifyCategoryName(CategoryDTO category) {

        // 제품분류명을 수정하는 로직
        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(CategoryDAO.class);

        boolean result = mapper.updateCategory(category);

        if(result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;

    }

    public boolean deleteCategory(Map<String, String> parameter) {

        // 제품분류 정보를 삭제하는 로직

        SqlSession sqlSession = getSqlSession();
        mapper = sqlSession.getMapper(CategoryDAO.class);

        boolean result = mapper.deleteCategory(parameter);

        if(result) {
            sqlSession.commit();
        } else {
            sqlSession.rollback();
        }
        sqlSession.close();
        return result;

    }
}
